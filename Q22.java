
//print entire http header
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class Q22 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            URLConnection connection = url.openConnection();
            connection.connect();

            Map<String, List<String>> headerFields = connection.getHeaderFields();

            System.out.println("=== HTTP Headers ===\n");

            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();

                if (key == null) {
                    System.out.println(values.get(0));
                } else {
                    System.out.println(key + ": " + String.join(", ", values));
                }
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
