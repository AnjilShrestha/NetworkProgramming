import java.net.InetAddress;
import java.net.UnknownHostException;

public class Q2 {
    public static void main(String args[]) {
        try {
            InetAddress address = InetAddress.getByName("www.google.com");
            System.out.println("Host Name: " + address.getHostName());
            System.out.println("Canonical Host Name: " + address.getCanonicalHostName());
            System.out.println("Host Address: " + address.getHostAddress());
            System.out.println("Is Loopback Address: " + address.isLoopbackAddress());
            System.out.println("Is Link Local Address: " + address.isLinkLocalAddress());
            System.out.println("Is Site Local Address: " + address.isSiteLocalAddress());
            System.out.println("Is Multicast Address: " + address.isMulticastAddress());
            System.out.println("Is Any Local Address: " + address.isAnyLocalAddress());
        } catch (UnknownHostException uhe) {
            System.out.println(uhe.getMessage());
        }
    }
}
