

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class NBPConnector {
    private static String url = "http://api.nbp.pl/api/exchangerates/rates/A/";

    private static String streamToString(InputStream inputStream) {
        String  text = new Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next();
        return text;
    }

    private static String jsonGetRequest(String urlQueryString) {
        String json = null;
        try {
            URL url = new URL(urlQueryString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("charset", "utf-8");
            connection.connect();
            InputStream inStream = connection.getInputStream();
            json = streamToString(inStream); // input stream to string
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }

    public static String exchangeRate(String currency){
        String resp = jsonGetRequest(url+currency);
        String [] arr = resp.split(",");
        resp = arr[arr.length-1];
        resp = resp.substring(6,resp.length()-3);
        return resp;
    }
}
