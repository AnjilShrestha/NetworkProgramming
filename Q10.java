import java.net.*;
import java.io.*;

public class Q10 {
    public static void main(String args[]) {
        try {
            int c;
            URL url = new URL("https://www.google.com/");
            URLConnection connection = url.openConnection();

            System.out.println("=== Retrieve data ===");
            try (InputStream input = connection.getInputStream()) {
                while ((c = input.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
