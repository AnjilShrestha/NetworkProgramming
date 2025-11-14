import java.net.*;
import java.util.Enumeration;
import java.util.Scanner;

public class Q7 {

    public static String getIPByInterfaceName(String interfaceName) throws SocketException {
        NetworkInterface networkInterface = NetworkInterface.getByName(interfaceName);
        if (networkInterface == null)
            return null;

        Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
        while (inetAddresses.hasMoreElements()) {
            InetAddress address = inetAddresses.nextElement();
            if (!address.isLoopbackAddress() && address instanceof Inet4Address) {
                return address.getHostAddress();
            }
        }
        return null;
    }

    public static String getIPByMACAddress(String macAddress) throws SocketException {
        macAddress = macAddress.toLowerCase().replace("-", ":");

        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface networkInterface = interfaces.nextElement();
            byte[] macBytes = networkInterface.getHardwareAddress();

            if (macBytes == null)
                continue;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < macBytes.length; i++) {
                sb.append(String.format("%02x", macBytes[i]));
                if (i != macBytes.length - 1)
                    sb.append(":");
            }

            if (sb.toString().equals(macAddress)) {
                Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress address = inetAddresses.nextElement();
                    if (!address.isLoopbackAddress() && address instanceof Inet4Address) {
                        return address.getHostAddress();
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter interface name (or leave blank): ");
        String iface = scanner.nextLine().trim();

        System.out.print("Enter MAC address (or leave blank): ");
        String mac = scanner.nextLine().trim();

        try {
            if (!iface.isEmpty()) {
                String ip = getIPByInterfaceName(iface);
                if (ip != null) {
                    System.out.println("IP for interface '" + iface + "': " + ip);
                } else {
                    System.out.println("No IP found for interface '" + iface + "'");
                }
            } else if (!mac.isEmpty()) {
                String ip = getIPByMACAddress(mac);
                if (ip != null) {
                    System.out.println("IP for MAC '" + mac + "': " + ip);
                } else {
                    System.out.println("No IP found for MAC '" + mac + "'");
                }
            } else {
                System.out.println("Please provide either an interface name or MAC address.");
            }
        } catch (SocketException e) {
            System.out.println("Error retrieving network info: " + e.getMessage());
        }
        scanner.close();
    }
}
