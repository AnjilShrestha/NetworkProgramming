
// a simple CookiePolicy that blocks cookies from .gov domains, but allows others.
import java.net.*;

public class Q17 {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                return !uri.getHost().endsWith(".gov");
            }
        });
        CookieHandler.setDefault(cookieManager);
        System.out.println("Simple Cookie Policy is set.");
    }
}
