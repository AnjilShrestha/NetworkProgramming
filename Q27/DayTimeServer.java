import java.io.*;
import java.util.*;
import java.net.*;

public class DayTimeServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4545);
        Socket s = ss.accept();
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Date dt = new Date();
        out.writeUTF(dt.toString());
        out.flush();
    }
}
