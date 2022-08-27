package com.github.yazui.cloudflare.exporter.api.objects;

public class CloudflareDomainOwner extends AbstractCloudflareComponent {

  private final String type;
  private final String email;

  public CloudflareDomainOwner(String id, String type, String email) {
    super(id);
    this.type = type;
    this.email = email;
  }

  public String getType() {
    return type;
  }

  public String getEmail() {
    return email;
  }
}
