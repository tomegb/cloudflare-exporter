package com.github.yazui.cloudflare.exporter.api.requests;

import com.github.yazui.cloudflare.exporter.api.CloudflareAccess;
import com.github.yazui.cloudflare.exporter.api.objects.CloudflareComponent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.lang.reflect.Type;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractRequest<T extends CloudflareComponent> {

  protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
  protected static final MediaType MEDIA_TYPE = MediaType.parse("text/plain");
  protected static final String CLOUDFLARE_API_LINK = "https://api.cloudflare.com/client/v4/";

  private final String path;
  private final String requestMethod;
  private final Class<T[]> responseClass;

  private T[] resultArray;
  private boolean succeed;
  private CloudflareError[] errors;

  protected AbstractRequest(String path, Class<T[]> responseClass) {
    this(path, "GET", responseClass);
  }

  protected AbstractRequest(String path, String requestMethod, Class<T[]> responseClass) {
    this.path = path;
    this.requestMethod = requestMethod;
    this.responseClass = responseClass;
  }

  public void executeRequest(@NotNull CloudflareAccess cloudflareAccess) throws IOException, IllegalAccessException {
    OkHttpClient client = cloudflareAccess.getClient();

    Builder builder = new Builder()
        .url(CLOUDFLARE_API_LINK + path)
        .addHeader("Authorization", "Bearer " + cloudflareAccess.getApiKey())
        .addHeader("X-Auth-Key", cloudflareAccess.getApiKey())
        .addHeader("X-Auth-Email", cloudflareAccess.getEmail());

    if (requestMethod.equalsIgnoreCase("GET")) {
      builder.get();
    } else {
      builder.method(requestMethod, RequestBody.create("", MEDIA_TYPE));
    }

    Request request = builder.build();
    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) {
        throw new IllegalStateException("Response is not successfully and results cannot be loaded.");
      }

      ResponseBody responseBody = response.body();
      if (responseBody == null) {
        throw new IllegalStateException("ResponseBody cannot be loaded.");
      }

      errors = GSON.fromJson(responseBodyObject.get("errors"));

      JsonObject responseBodyObject = JsonParser.parseString(responseBody.string()).getAsJsonObject();
      if (!responseBodyObject.has("success") && !responseBodyObject.get("success").getAsBoolean()) {
        throw new IllegalAccessException();
      }

      if (!responseBodyObject.has("errors") && !responseBodyObject.get("errors").getAsBoolean()) {
        throw new IllegalAccessException();
      }

      if (!responseBodyObject.has("result")) {
        throw new IllegalAccessException();
      }

      resultArray = GSON.fromJson(responseBodyObject.get("result"), (Type) responseClass);
    }
  }

  public T[] getResults() {
    return resultArray;
  }

  public boolean isSucceed() {
    return succeed;
  }

  public CloudflareError[] getErrors() {
    return errors;
  }

  public record CloudflareError(int errorCode, String errorMessage) {

  }

}
