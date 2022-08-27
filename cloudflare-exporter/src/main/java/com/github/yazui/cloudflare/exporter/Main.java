package com.github.yazui.cloudflare.exporter;

import com.github.yazui.cloudflare.exporter.api.CloudflareAccess;
import com.github.yazui.cloudflare.exporter.api.requests.RequestRunner;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        System.out.println("       _                 _  __ _                                               _            \n" +
                           "      | |               | |/ _| |                                             | |           \n" +
                           "   ___| | ___  _   _  __| | |_| | __ _ _ __ ___      _____  ___ __   ___  _ __| |_ ___ _ __ \n" +
                           "  / __| |/ _ \\| | | |/ _` |  _| |/ _` | '__/ _ \\    / _ \\ \\/ / '_ \\ / _ \\| '__| __/ _ \\ '__|\n" +
                           " | (__| | (_) | |_| | (_| | | | | (_| | | |  __/   |  __/>  <| |_) | (_) | |  | ||  __/ |   \n" +
                           "  \\___|_|\\___/ \\__,_|\\__,_|_| |_|\\__,_|_|  \\___|    \\___/_/\\_\\ .__/ \\___/|_|   \\__\\___|_|   \n" +
                           "                                                             | |                            \n" +
                           "                                                             |_|                            ");

        Timer time = new Timer();
        RequestRunner st = new RequestRunner(new CloudflareAccess(mail, key));
        time.schedule(st, 0, TimeUnit.SECONDS.toMillis(30));
    }
}


 /*
   public void insertData() {
    InfluxDBClient connection = new InfluxDBConnection("token", "bucket", "org", "url")
        .buildConnection();

    WriteApiBlocking writeApi = connection.getWriteApiBlocking();
    Point point = Point.measurement("requests")
        .addField("requests", "")
        .time(Instant.now(), WritePrecision.MS);
    writeApi.writePoint(point);
  }
  */
