package Q35;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;

public class SecureServer {
    public static SSLServerSocket createServerSocket(SSLContext sslContext, int port) throws IOException {
        SSLServerSocketFactory factory = sslContext.getServerSocketFactory();
        return (SSLServerSocket) factory.createServerSocket(port);
    }

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = SSLContextWithTrustStore.createSSLContext(
                "E:\\BCA\\6thsem\\NetworkingLab\\Q35\\mykeystore.jks", "anjilbca",
                "E:\\BCA\\6thsem\\NetworkingLab\\Q35\\mytruststore.jks", "anjilbca");

        SSLServerSocket serverSocket = createServerSocket(sslContext, 8443);
        System.out.println("Secure server started on port 8443...");

        while (true) {
            try (SSLSocket client = (SSLSocket) serverSocket.accept()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Received: " + line);
                    writer.write("Echo: " + line + "\n");
                    writer.flush();
                    if (line.equalsIgnoreCase("bye")) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.err.println("Error handling client: " + e.getMessage());
            }
        }
    }
}
