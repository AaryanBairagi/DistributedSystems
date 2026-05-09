import java.rmi.*;

public interface MulInterface extends Remote
{
    public int multiply(int a, int b) throws RemoteException;
}