import java.net.*;
import java.util.*;

public class Q5 {
    public static void main(String[] args) throws Exception {
        ArrayList<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        System.out.println("Information about present Network Interfaces...\n");
        for (NetworkInterface iface : interfaces) {
            if (iface.isUp()) {
                System.out.println("Interface Name: " + iface.getName());
                System.out.println("Interface display name: " + iface.getDisplayName());
                System.out.println("Hardware Address: " + Arrays.toString(iface.getHardwareAddress()));
                System.out.println("Parent: " + iface.getParent());
                System.out.println("Index: " + iface.getIndex());
                System.out.println("\tInterface addresses: ");
                for (InterfaceAddress addr : iface.getInterfaceAddresses()) {
                    System.out.println("\t\t" + addr.getAddress().toString());
                }
                System.out.println("\tInetAddresses associated with this interface: ");
                Enumeration<InetAddress> en = iface.getInetAddresses();
                while (en.hasMoreElements()) {
                    System.out.println("\t\t" + en.nextElement().toString());
                }
                System.out.println("\tMTU: " + iface.getMTU());
                System.out.println("\tSubinterfaces: " + Collections.list(iface.getSubInterfaces()));
                System.out.println("\this loopback: " + iface.isLoopback());
                System.out.println("\this virtual: " + iface.isVirtual());
                System.out.println("\this point to point: " + iface.isPointToPoint());
                System.out.println("Supports Multicast: " + iface.supportsMulticast());
            }
        }
    }
}