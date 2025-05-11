import java.net.InetAddress;

public class Q3 {
    public static void main(String[] rags) {
        try {
            InetAddress address = InetAddress.getByName("192.168.1.73");
            System.out.println("Address:" + address.getHostAddress());
            System.out.println("Host name:" + address.getHostName());

            System.out.println("isAnyLocalAddress(): " + address.isAnyLocalAddress());

            System.out.println("isLoopBackAddress(): " + address.isLoopbackAddress());
            System.out.println("isLinkLocalAddress():" + address.isLinkLocalAddress());
            System.out.println("isSiteLocalAddress():" + address.isSiteLocalAddress());
            System.out.println("isMulticastAddress():" + address.isMulticastAddress());
            System.out.println("isMCGlobal():" + address.isMCGlobal());
            System.out.println("isMCNodeLocal():" + address.isMCNodeLocal());
            System.out.println("isMCLinkLocal():" + address.isMCLinkLocal());

        } catch (Exception e) {
            System.out.println("Exception:" + e.getMessage());
        }
    }
}
