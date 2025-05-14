
//parts of uri
import java.net.*;

public class Q13 {
    public static void main(String args[]) throws Exception {
        String u = "http://www.xml.com/pub/a/2003/09/17/stax.html#id=_hbc";
        try {
            URI uri = new URI(u);

            System.out.println("Full URI: " + uri);
            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("User Info: " + uri.getUserInfo());
            System.out.println("Host : " + uri.getHost());
            System.out.println("Port : " + uri.getPort());
            System.out.println("Path : " + uri.getPath());
            System.out.println("Query : " + uri.getQuery());
            System.out.println("Fragment : " + uri.getFragment());

        } catch (Exception e) {
            System.out.println("Invalid URI: " + e.getMessage());
        }
    }

}
