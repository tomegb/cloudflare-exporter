package com.github.yazui.cloudflare.exporter.api;

import okhttp3.OkHttpClient;

public class CloudflareAccess {

  private final String apiKey;
  private final String email;
  private final OkHttpClient client;

  public static final String CLOUDFLARE_API_LINK = "https://api.cloudflare.com/client/v4";

  public CloudflareAccess(String mail, String apiKey) {
    this.email = mail;
    this.apiKey = apiKey;
    this.client = new OkHttpClient();
  }

  public OkHttpClient getClient() {
    return client;
  }

  public String getApiKey() {
    return apiKey;
  }

  public String getEmail() {
    return email;
  }
}

