import java.net.*;

public class Q6 {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("IP Address: " + localHost.getHostAddress());

            NetworkInterface network = NetworkInterface.getByInetAddress(localHost);
            if (network != null) {
                byte[] mac = network.getHardwareAddress();

                if (mac != null) {
                    StringBuilder macStr = new StringBuilder();
                    for (int i = 0; i < mac.length; i++) {
                        macStr.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
                    }
                    System.out.println("MAC Address: " + macStr);
                } else {
                    System.out.println("MAC Address not available.");
                }
            } else {
                System.out.println("No network interface found for this IP.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
