package Q39;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPDayTimeClient {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName("localhost");
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 12345);
            socket.send(packet);
            packet = new DatagramPacket(new byte[1024], 1024);
            socket.receive(packet);
            String received = new String(packet.getData());
            System.out.println("Current Date and Time: " + received);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
