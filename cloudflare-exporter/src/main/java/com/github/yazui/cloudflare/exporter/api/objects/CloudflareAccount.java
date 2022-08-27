package com.github.yazui.cloudflare.exporter.api.objects;

public class CloudflareAccount extends AbstractCloudflareComponent {

  private final String name;

  public CloudflareAccount(String id, String name) {
    super(id);
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
