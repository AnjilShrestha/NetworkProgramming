import java.net.DatagramSocket;

public class Q42 {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(5000);
            socket.setReuseAddress(true);
            System.out.println("Socket options set:");
            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("ReuseAddress: " + socket.getReuseAddress());
            // Add more socket options as needed
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
