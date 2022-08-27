package com.github.yazui.cloudflare.exporter.api.requests;

import com.github.yazui.cloudflare.exporter.api.CloudflareAccess;
import java.util.TimerTask;

public class RequestRunner extends TimerTask {

  private final CloudflareAccess cloudflareAccess;

  private long lastCacheTime = 0L;

  public RequestRunner(CloudflareAccess cloudflareAccess) {
    this.cloudflareAccess = cloudflareAccess;
  }

  public void run() {

  }
}

