import java.rmi.*;

public interface DivInterface extends Remote
{
    public float divide(int a, int b) throws RemoteException;
}