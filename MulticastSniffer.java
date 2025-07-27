import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSniffer {
    public static void main(String[] args) {
        final String MULTICAST_IP = "230.0.0.1";
        final int PORT = 4446;

        try {

            MulticastSocket socket = new MulticastSocket(PORT);
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            socket.joinGroup(group);

            System.out.println("Listening to multicast group " + MULTICAST_IP + " on port " + PORT + "...");

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String msg = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received multicast message: " + msg);
            }
        } catch (Exception e) {
            System.out.println("Multicast Sniffer Error: " + e.getMessage());
        }
    }
}
