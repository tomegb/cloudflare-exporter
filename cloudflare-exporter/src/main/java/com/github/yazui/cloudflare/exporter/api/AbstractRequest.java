package com.github.yazui.cloudflare.exporter.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class AbstractRequest<T extends CloudflareComponent> {

  protected static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  private T[] resultArray;
  private final boolean succeed;
  private final CloudflareError[] errors;

  protected AbstractRequest(boolean succeed, CloudflareError... errors) {
    this.succeed = succeed;
    this.errors = errors;
  }

  public void executeRequest(CloudflareAccess cloudflareAccess) {

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

  public record CloudflareError(int errorCode, String errorMessage) { }

}
