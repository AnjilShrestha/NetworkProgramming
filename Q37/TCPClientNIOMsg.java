package Q37;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TCPClientNIOMsg {
    public static void main(String[] args) {
        try (SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("localhost",
                12345));
                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                buffer.put(userInput.getBytes());
                buffer.flip();
                clientChannel.write(buffer);
                buffer.clear();
                clientChannel.read(buffer);
                buffer.flip();
                System.out.println("Server Response: " + new String(buffer.array(), 0, buffer.limit()));
                buffer.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
