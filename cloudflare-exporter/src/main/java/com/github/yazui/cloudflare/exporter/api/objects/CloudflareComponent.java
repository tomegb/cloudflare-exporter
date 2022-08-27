package com.github.yazui.cloudflare.exporter.api.objects;

public abstract class CloudflareComponent {

  private final String id;

  protected CloudflareComponent(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
