package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiHandler {

    public static ApiHandler INSTANCE;

    public static void main(String[] args) {
        try {
            ApiHandler.callMe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ApiResponse callMe() throws Exception {
        String url = "https://api.tomegb.cloud/germany";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = con.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        JSONObject myResponse = new JSONObject(response.toString());
        Object cases = myResponse.get("cases");
        Object deaths = myResponse.get("deaths");
        Object recovered = myResponse.get("recovered");
        return new ApiResponse((int) cases, (int) deaths, (int) recovered);
    }
}
