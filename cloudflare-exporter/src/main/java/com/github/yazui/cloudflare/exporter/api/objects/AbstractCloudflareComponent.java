package com.github.yazui.cloudflare.exporter.api.objects;

public abstract class AbstractCloudflareComponent {

  private final String id;

  protected AbstractCloudflareComponent(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
