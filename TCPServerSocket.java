import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSocket {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            serverSocket.setReuseAddress(true);
            System.out.println("Server socket options set:");
            System.out.println("ReuseAddress: " + serverSocket.getReuseAddress());
            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.setSoTimeout(5000); // 5 seconds timeout
                clientSocket.setTcpNoDelay(true); // Disable Nagle's algorithm
                System.out.println("Client socket options set:");
                System.out.println("SoTimeout: " + clientSocket.getSoTimeout());
                System.out.println("TcpNoDelay: " + clientSocket.getTcpNoDelay());
                // Handle client connection in a separate thread or as needed
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
