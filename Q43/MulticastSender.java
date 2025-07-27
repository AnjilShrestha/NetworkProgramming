package Q43;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MulticastSender {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1"; // Multicast group IP
        int port = 5000;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            String message = "Hello, Multicast!";
            byte[] buffer = message.getBytes();

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);

            System.out.println("Multicast message sent: " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
