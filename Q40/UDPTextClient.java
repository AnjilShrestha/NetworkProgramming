package Q40;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPTextClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("localhost");
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Enter message to send to server: ");
                String message = scanner.nextLine();

                byte[] sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer, sendBuffer.length, serverAddress, 5000);
                clientSocket.send(sendPacket);

                // Receive response
                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);

                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Response from server: " + serverResponse);
            }
        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }
}
