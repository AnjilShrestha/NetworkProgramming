import java.net.*;
import java.util.*;

public class Q8 {

    public static String getMACAddress(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            NetworkInterface networkInterface = NetworkInterface.getByInetAddress(address);
            if (networkInterface == null) {
                return "No network interface found for the given IP.";
            }

            byte[] macBytes = networkInterface.getHardwareAddress();
            if (macBytes == null) {
                return "MAC address could not be retrieved.";
            }

            StringBuilder macAddress = new StringBuilder();
            for (int i = 0; i < macBytes.length; i++) {
                macAddress.append(String.format("%02X%s", macBytes[i], (i < macBytes.length - 1) ? "-" : ""));
            }

            return macAddress.toString();

        } catch (Exception e) {
            return "Error retrieving MAC address: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an IP address: ");
        String ip = scanner.nextLine().trim();

        String mac = getMACAddress(ip);
        System.out.println("MAC Address: " + mac);

        scanner.close();
    }
}
