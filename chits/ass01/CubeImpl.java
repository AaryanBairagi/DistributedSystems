import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CubeImpl extends UnicastRemoteObject implements CubeInterface
{
    protected CubeImpl() throws RemoteException
    {
        super();
    }

    public int cube(int n) throws RemoteException
    {
        return n * n * n;
    }
}