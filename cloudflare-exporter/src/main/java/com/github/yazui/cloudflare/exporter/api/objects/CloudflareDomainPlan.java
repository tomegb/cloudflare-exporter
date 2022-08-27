package com.github.yazui.cloudflare.exporter.api.objects;

import com.google.gson.annotations.SerializedName;

public class CloudflareDomainPlan extends AbstractCloudflareComponent {

  private final String name;
  private final double price;
  private final String currency;
  @SerializedName("is_subscribed")
  private final boolean subscribed;
  @SerializedName("can_subscribe")
  private final boolean canSubscribe;
  @SerializedName("legacy_id")
  private final String legacyId;
  @SerializedName("legacy_discount")
  private final boolean legacyDiscount;
  @SerializedName("externally_managed")
  private final boolean externallyManaged;

  public CloudflareDomainPlan(String id, String name, double price, String currency, boolean subscribed,
      boolean canSubscribe, String legacyId, boolean legacyDiscount, boolean externallyManaged) {
    super(id);
    this.name = name;
    this.price = price;
    this.currency = currency;
    this.subscribed = subscribed;
    this.canSubscribe = canSubscribe;
    this.legacyId = legacyId;
    this.legacyDiscount = legacyDiscount;
    this.externallyManaged = externallyManaged;
  }

  public String getName() {
    return name;
  }

  public double getPrice() {
    return price;
  }

  public String getCurrency() {
    return currency;
  }

  public boolean isSubscribed() {
    return subscribed;
  }

  public boolean isCanSubscribe() {
    return canSubscribe;
  }

  public String getLegacyId() {
    return legacyId;
  }

  public boolean isLegacyDiscount() {
    return legacyDiscount;
  }

  public boolean isExternallyManaged() {
    return externallyManaged;
  }
}
