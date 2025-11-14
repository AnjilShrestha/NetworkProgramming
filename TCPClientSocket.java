import java.net.Socket;

public class TCPClientSocket {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345)) {
            socket.setSoTimeout(5000);
            socket.setTcpNoDelay(true);
            socket.setReuseAddress(true);
            System.out.println("Socket options set:");
            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("TcpNoDelay: " + socket.getTcpNoDelay());
            System.out.println("ReuseAddress: " + socket.getReuseAddress());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
