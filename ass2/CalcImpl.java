import java.rmi.*;
import java.rmi.server.*;

public class CalcImpl extends UnicastRemoteObject implements Calc {
    protected CalcImpl() throws RemoteException {}

    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}