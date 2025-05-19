import java.net.*;
import java.io.*;

public class FileClient {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("localhost", 45456);
            BufferedReader br = new BufferedReader(new FileReader("E:\\File.txt"));
            String str = br.readLine();
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            out.writeUTF(str);
            System.out.println("Transfer Complete");
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
