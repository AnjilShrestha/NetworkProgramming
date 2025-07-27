package Q45;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GCDInterface extends Remote {
    int gcd(int a, int b) throws RemoteException;
}
