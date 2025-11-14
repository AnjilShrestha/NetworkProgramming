import java.net.*;
import java.util.*;

public class Q9 {

    public static void main(String[] args) {
        try {
            System.out.println("Listing all network interfaces using factory method getNetworkInterfaces():\n");
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface netIf = interfaces.nextElement();
                displayInterfaceDetails(netIf);
            }

            System.out.println("\nUsing factory method getByName(\"lo\"):");
            NetworkInterface loopback = NetworkInterface.getByName("lo");
            if (loopback != null) {
                displayInterfaceDetails(loopback);
            } else {
                System.out.println("No interface found with name 'lo'");
            }

            System.out.println("\nUsing factory method getByInetAddress(InetAddress):");
            InetAddress localHost = InetAddress.getLocalHost();
            NetworkInterface fromIP = NetworkInterface.getByInetAddress(localHost);
            if (fromIP != null) {
                displayInterfaceDetails(fromIP);
            } else {
                System.out.println("No interface found for IP: " + localHost.getHostAddress());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // getter methods of NetworkInterface
    public static void displayInterfaceDetails(NetworkInterface netIf) throws SocketException {
        System.out.println("-------------------------------------------------");
        System.out.println("Interface Name      : " + netIf.getName());
        System.out.println("Display Name        : " + netIf.getDisplayName());
        byte[] mac = netIf.getHardwareAddress();
        if (mac != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println("MAC Address         : " + sb);
        } else {
            System.out.println("MAC Address         : Not available");
        }

        System.out.println("IP Addresses:");
        Enumeration<InetAddress> inetAddresses = netIf.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress inetAddress = inetAddresses.nextElement();
            System.out.println("\t" + inetAddress.getHostAddress());
        }
    }
}
