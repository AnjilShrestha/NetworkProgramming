package Q45;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GCDServer extends UnicastRemoteObject implements GCDInterface {
    protected GCDServer() throws RemoteException {
        super();
    }

    public int gcd(int a, int b) throws RemoteException {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        try {
            GCDServer server = new GCDServer();
            Registry registry = LocateRegistry.createRegistry(8090);
            registry.rebind("GCDServer", server);
            System.out.println("GCD Server is ready on port 8090.");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}