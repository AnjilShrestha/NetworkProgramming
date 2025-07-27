package Q43;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        String multicastAddress = "230.0.0.1";
        int port = 5000;
        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group);

            System.out.println("Joined multicast group. Waiting for messages...");

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());

            System.out.println("Received multicast message: " + received);
            socket.leaveGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}