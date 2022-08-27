package com.github.yazui.cloudflare.exporter.api.objects;

import com.google.gson.annotations.SerializedName;

public class CloudflareZone extends AbstractCloudflareComponent {

  private final String name;
  private final String status;
  private final boolean paused;
  private final String type;
  @SerializedName("name_servers")
  private final String[] nameServers;
  @SerializedName("original_name_servers")
  private final String[] originalNameServers;
  private final CloudflareDomainOwner owner;
  private final CloudflareAccount account;
  private final String[] permissions;
  private final CloudflareDomainPlan plan;

  public CloudflareZone(String id, String name, String status, boolean paused, String type, String[] nameServers,
      String[] originalNameServers, CloudflareDomainOwner owner, CloudflareAccount account, String[] permissions,
      CloudflareDomainPlan plan) {
    super(id);
    this.name = name;
    this.status = status;
    this.paused = paused;
    this.type = type;
    this.nameServers = nameServers;
    this.originalNameServers = originalNameServers;
    this.owner = owner;
    this.account = account;
    this.permissions = permissions;
    this.plan = plan;
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

  public String[] getNameServers() {
    return nameServers;
  }

  public String[] getOriginalNameServers() {
    return originalNameServers;
  }

  public CloudflareDomainOwner getOwner() {
    return owner;
  }

  public CloudflareAccount getAccount() {
    return account;
  }

  public String[] getPermissions() {
    return permissions;
  }

  public CloudflareDomainPlan getPlan() {
    return plan;
  }
}
