
// retrieving information from header using arbitrary header methods. 
import java.net.*;
import java.io.*;
import java.util.*;

public class Q20 {

    public static void main(String[] args) throws MalformedURLException, IOException {
        URL u = new URL("http://www.tu.edu.np");
        URLConnection uc = u.openConnection();
        System.out.println("Content Type:" + uc.getHeaderField("content-type"));
        System.out.println("Content Encoding:" + uc.getHeaderField("content-encoding"));
        System.out.println("Date" + new Date(uc.getHeaderField("date")));
        System.out.println("Date" + (uc.getHeaderField("date")));
        System.out.println("Expiry Date:" + (uc.getHeaderField("expiry date")));
        System.out.println("Result:" + uc.getHeaderFieldKey(3));
        for (int i = 1;; i++) {
            String header = uc.getHeaderField(i);
            if (header == null)
                break;
            else {
                System.out.println(i + ":" + uc.getHeaderFieldKey(i) + ":" + header);
            }
        }
        System.out.println("get connection time :" + uc.getConnectTimeout());
        uc.setConnectTimeout(100);
    }
}