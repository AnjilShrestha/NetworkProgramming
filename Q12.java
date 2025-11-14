import java.net.*;

public class Q12 {
    private static void testProtocol(String url) {
        try {
            URL ur = new URL(url);
            System.out.println(ur.getProtocol() + " is supported");

        } catch (Exception e) {
            String protocol = url.substring(0, url.indexOf(':'));
            System.out.println(protocol + " is not supported");
        }
    }

    public static void main(String[] args) {
        testProtocol("http://www.adc.org");
        testProtocol("https://www.amazon.com/exec/obidos/order2/");
        testProtocol("ftp://ibiblio.org/pub/languages/java/javafaq");
        testProtocol("mailto:elharo@ibiblio.org");
        testProtocol("telnet://dibner.poly.edu/");
        testProtocol("gopher://gopher.anc.org.za/");
    }
}
