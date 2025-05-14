
//url decoder
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class Q15 {
    public static void main(String[] args) {
        try {
            String encodedURL = "https%3A%2F%2Fwww.networklab.com%2Fsearch%3Fquery%3Djava+programming%26lang%3Den";
            System.out.println("Encoded URL: " + encodedURL);

            // Decoding the URL
            String decodedURL = URLDecoder.decode(encodedURL, StandardCharsets.UTF_8.name());
            System.out.println("Decoded URL: " + decodedURL);
        } catch (Exception e) {
            System.out.println("Error decoding URL: " + e.getMessage());
        }
    }
}
