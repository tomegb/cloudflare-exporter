package influxdb;

public class InfluxClient {
    ApiResponse r;
	    try {
        r = ApiHandler.call_me();
    } catch (Exception e) {
        e.printStackTrace();
        return;
    }


}
