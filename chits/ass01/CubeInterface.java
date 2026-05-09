import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CubeInterface extends Remote
{
    public int cube(int n) throws RemoteException;
}