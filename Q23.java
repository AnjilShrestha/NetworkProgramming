
//configure url connection
import java.net.HttpURLConnection;
import java.net.URL;

public class Q23 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.facebook.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.setReadTimeout(3000);
            connection.connect();
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
