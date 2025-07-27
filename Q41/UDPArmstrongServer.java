package Q41;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPArmstrongServer {
    public static void main(String[] args) {
        try (DatagramSocket socket = new DatagramSocket(12345)) {
            System.out.println("UDP Armstrong Server started...");
            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                int number = Integer.parseInt(received);
                String responseMessage = number + " is " + (isArmstrong(number) ? "an Armstrong number."
                        : "not an Armstrong number.");
                byte[] responseBuffer = responseMessage.getBytes();
                DatagramPacket response = new DatagramPacket(responseBuffer, responseBuffer.length,
                        packet.getAddress(), packet.getPort());
                socket.send(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isArmstrong(int number) {
        int original = number, sum = 0, digits = String.valueOf(number).length();
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        return sum == original;
    }
}
