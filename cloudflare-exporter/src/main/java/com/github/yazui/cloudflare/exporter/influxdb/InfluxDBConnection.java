package com.github.yazui.cloudflare.exporter.influxdb;

import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;

public record InfluxDBConnection(String token, String bucket, String org, String url) {

  public InfluxDBClient buildConnection() {
    return InfluxDBClientFactory.create(url(), token().toCharArray(), org(), bucket());
  }

}
