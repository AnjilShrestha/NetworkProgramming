import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HTTPFileServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            System.out.println("HTTP File Server started...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                        OutputStream out = clientSocket.getOutputStream()) {
                    File file = new File("file.txt");
                    FileInputStream fis = new FileInputStream(file);
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    out.write(("HTTP/1.1 200 OK\r\n").getBytes());
                    out.write(("Content-Length: " + file.length() + "\r\n").getBytes());
                    out.write(("\r\n").getBytes());
                    while ((bytesRead = fis.read(buffer)) != -1) {
                        out.write(buffer, 0, bytesRead);
                    }
                    fis.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
