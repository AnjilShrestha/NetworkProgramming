import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class Q16 extends ProxySelector {
    private List<Proxy> proxies = new ArrayList<>();

    public Q16() {
        proxies.add(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("proxy.example.com", 8080)));
    }

    @Override
    public List<Proxy> select(URI uri) {
        return proxies;
    }

    @Override
    public void connectFailed(URI uri, java.net.SocketAddress sa, java.io.IOException ioe) {
        System.out.println("Connection failed to " + uri);
    }

    public static void main(String[] args) {
        ProxySelector.setDefault(new Q16());
        System.out.println("Custom Proxy Selector is set.");
    }
}
