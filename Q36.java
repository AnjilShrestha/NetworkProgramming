//udp socket info

import java.net.DatagramSocket;

public class Q36 {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(5000);
            socket.setReuseAddress(true);
            System.out.println("Socket information:");
            System.out.println("SoTimeout: " + socket.getSoTimeout());
            System.out.println("ReuseAddress: " + socket.getReuseAddress());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
