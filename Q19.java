
// retrieving information from header using header specific methods.
import java.io.IOException;
import java.net.*;
import java.util.*;

public class Q19 {
    public static void main(String[] args) throws MalformedURLException, IOException {
        URL u = new URL("http://www.tu.edu.np");
        URLConnection uc = u.openConnection();
        System.out.println("Content-Type:" + uc.getContentType());
        System.out.println("Content-Length:" + uc.getContentLength());
        System.out.println("Content-Encoding:" + uc.getContentEncoding());
        System.out.println("Date:" + new Date(uc.getDate()));
        System.out.println("Expiry Date:" + new Date(uc.getExpiration()));
        System.out.println("Last modified Date:" + new Date(uc.getLastModified()));

    }
}