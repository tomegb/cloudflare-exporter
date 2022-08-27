package com.github.yazui.cloudflare.exporter.api.requests;

import com.github.yazui.cloudflare.exporter.api.objects.CloudflareZone;
import com.github.yazui.cloudflare.exporter.influxdb.InfluxDBConnection;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.WriteApiBlocking;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import java.time.Instant;

public class CloudflareGetZoneRequest extends AbstractRequest<CloudflareZone> {

  public CloudflareGetZoneRequest() {
    super("zones", CloudflareZone[].class);
  }

  public void insertData() {
    InfluxDBClient connection = new InfluxDBConnection("token", "bucket", "org", "url")
        .buildConnection();

    WriteApiBlocking writeApi = connection.getWriteApiBlocking();
    Point point = Point.measurement("requests")
        .addTag("sensor_id", "TLM0100")
        .addField("location", "Main Lobby")
        .addField("model_number", "TLM89092A")
        .time(Instant.now(), WritePrecision.MS);
    writeApi.writePoint(point);
  }


}
