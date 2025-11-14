
//retrieve cookie information
import java.net.*;
import java.util.List;

public class Q18 {
    public static void main(String[] args) throws Exception {
        CookieHandler.setDefault(new CookieManager());
        URL url = new URL("https://www.facebook.com");
        URLConnection connection = url.openConnection();
        connection.getContent();
        List<HttpCookie> cookies = ((CookieManager) CookieHandler.getDefault()).getCookieStore().getCookies();
        for (HttpCookie cookie : cookies) {
            System.out.println("Cookie: " + cookie.getName() + " = " + cookie.getValue());
        }
    }

}
