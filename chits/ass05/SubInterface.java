import java.rmi.*;

public interface SubInterface extends Remote
{
    public int sub(int a, int b) throws RemoteException;
}