package Q45;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class GCDClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        GCDInterface gcd = (GCDInterface) Naming.lookup("rmi://localhost:8090/GCDServer");
        int a = 40, b = 90;
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd.gcd(a, b));

    }
}
