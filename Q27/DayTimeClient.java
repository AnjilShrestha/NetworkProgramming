import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class DayTimeClient {
    public static void main(String[] args) throws IOException {
        Socket soc = new Socket("localhost", 4545);
        DataInputStream in = new DataInputStream(soc.getInputStream());
        String date = in.readUTF();
        System.out.println("Date from Server: " + date);
    }
}
