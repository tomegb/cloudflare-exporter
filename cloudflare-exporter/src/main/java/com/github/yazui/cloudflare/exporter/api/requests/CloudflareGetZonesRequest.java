package com.github.yazui.cloudflare.exporter.api.requests;

import com.github.yazui.cloudflare.exporter.api.objects.CloudflareZone;

public class CloudflareGetZonesRequest extends AbstractRequest<CloudflareZone> {

  public CloudflareGetZonesRequest() {
    super("zones", CloudflareZone[].class);
  }

}
