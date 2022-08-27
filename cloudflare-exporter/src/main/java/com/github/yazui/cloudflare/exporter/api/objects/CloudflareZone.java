package com.github.yazui.cloudflare.exporter.api.objects;

public class CloudflareZone extends CloudflareComponent {

  private final String name;
  private final String status;
  private final boolean paused;
  private final String type;

  public CloudflareZone(String id, String name, String status, boolean paused, String type) {
    super(id);
    this.name = name;
    this.status = status;
    this.paused = paused;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getStatus() {
    return status;
  }

  public boolean isPaused() {
    return paused;
  }

  public String getType() {
    return type;
  }

}
