package Q37;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class TCPServerNIOMsg {
    public static void main(String[] args) {
        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(12345));
            System.out.println("NIO Text Server started...");
            while (true) {
                try (SocketChannel clientChannel = serverChannel.accept()) {
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    while (clientChannel.read(buffer) > 0) {
                        buffer.flip();
                        clientChannel.write(buffer);
                        buffer.clear();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
