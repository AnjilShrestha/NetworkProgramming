import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FactorialServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(34345);
        Socket s = ss.accept();
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        int num = Integer.parseInt(in.readUTF());
        int fact = 1;
        for (int i = num; i > 0; i--) {
            fact *= i;
        }
        out.writeUTF(String.valueOf(fact));
        out.flush();
    }
}
