import java.net.URL;

public class Q11 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.tutorialspoint.com/java/util/linkedhashmap_values.htm");

            // Splitting the URL
            System.out.println("Protocol : " + url.getProtocol());
            System.out.println("Host : " + url.getHost());
            System.out.println("Port : " + url.getPort()); // returns -1 if no port is specified
            System.out.println("Default Port : " + url.getDefaultPort());
            System.out.println("Path : " + url.getPath());
            System.out.println("Query : " + url.getQuery());
            System.out.println("File : " + url.getFile());
            System.out.println("Ref : " + url.getRef());
            System.out.println("Authority : " + url.getAuthority());
            System.out.println("User Info : " + url.getUserInfo());
        } catch (Exception e) {
            System.out.println("Invalid URL: " + e.getMessage());
        }
    }
}
