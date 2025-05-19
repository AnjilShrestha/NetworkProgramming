package Q35;

import javax.net.ssl.*;
import java.io.*;

public class SecureClient {

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = SSLContextWithTrustStore.createSSLContext(
                "E:\\BCA\\6thsem\\NetworkingLab\\Q35\\mykeystore.jks",
                "anjilbca",
                "E:\\BCA\\6thsem\\NetworkingLab\\Q35\\mytruststore.jks",
                "anjilbca");

        SSLSocketFactory socketFactory = sslContext.getSocketFactory();

        try (SSLSocket connection = (SSLSocket) socketFactory.createSocket("localhost", 8443);
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {

            System.out.println("Connected to secure server. Type your messages:");
            String userInput;
            while ((userInput = console.readLine()) != null) {
                writer.write(userInput + "\n");
                writer.flush();

                String response = reader.readLine();
                if (response == null)
                    break;
                System.out.println("Server replied: " + response);

                if ("bye".equalsIgnoreCase(userInput)) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}
