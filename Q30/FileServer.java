import java.net.*;
import java.io.*;

public class FileServer {
    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(45456);
            Socket s = ss.accept();
            DataInputStream in = new DataInputStream(s.getInputStream());
            String str = in.readUTF();
            FileOutputStream out = new FileOutputStream("E:\\test.txt");
            byte[] buf = str.getBytes();
            out.write(buf);
            System.out.println("File Transferred");
        } catch (IOException e) {
            System.out.println("Exception : " + e);
        }
    }
}
