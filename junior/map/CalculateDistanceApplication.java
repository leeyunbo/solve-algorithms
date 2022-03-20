package junior.map;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

public class CalculateDistanceApplication {

    private static final String requestURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode";
    private static final String CLIENT_ID = "xmk4kcvlm3";
    private static final String CLIENT_SECRET = "IjZH88NTxTmZGHYxSyXOvyvBgDq3LX9j6eoLhqSl";


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("주소를 입력 해주세요 : ");
        String query = URLEncoder.encode(sc.nextLine(), "utf-8");

        URL url = new URL(requestURL + "?query=" + query);
        HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
        if (httpsURLConnection != null) {
            System.out.println("Connection start");
            httpsURLConnection.setConnectTimeout(10000);
            httpsURLConnection.setRequestMethod("GET");
            httpsURLConnection.setRequestProperty("X-NCP-APIGW-API-KEY-ID", CLIENT_ID);
            httpsURLConnection.setRequestProperty("X-NCP-APIGW-API-KEY", CLIENT_SECRET);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(true);

            int statusCode = httpsURLConnection.getResponseCode();
            System.out.println("status code : " + statusCode);
            if(statusCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream(), "utf-8"));
                StringBuffer stringBuffer = new StringBuffer();
                String line = null;
                while((line = reader.readLine()) != null) {
                    stringBuffer.append(line).append("\n");
                }

                System.out.println(stringBuffer.toString());
                reader.close();
            }

            httpsURLConnection.disconnect();
        }
    }

    private double distanceInKilometerByHaversine(double x1, double y1, double x2, double y2) {
        double distance;
        double radius = 6371; // 지구 반지름(km)
        double toRadian = Math.PI / 180;

        double deltaLatitude = Math.abs(x1 - x2) * toRadian;
        double deltaLongitude = Math.abs(y1 - y2) * toRadian;

        double sinDeltaLat = Math.sin(deltaLatitude / 2);
        double sinDeltaLng = Math.sin(deltaLongitude / 2);
        double squareRoot = Math.sqrt(
                sinDeltaLat * sinDeltaLat +
                        Math.cos(x1 * toRadian) * Math.cos(x2 * toRadian) * sinDeltaLng * sinDeltaLng);

        distance = 2 * radius * Math.asin(squareRoot);

        return distance;
    }
}
