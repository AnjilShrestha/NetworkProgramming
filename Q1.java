import java.net.InetAddress;
import java.net.UnknownHostException;

public class Q1 {
    public static void main(String args[]) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();

            System.out.println("System name" + localhost.getHostName());

            System.out.println("IP Address" + localhost.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        }
    }
}
