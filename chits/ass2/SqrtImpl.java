import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class SqrtImpl extends UnicastRemoteObject implements SqrtInterface
{
    protected SqrtImpl() throws RemoteException
    {
        super();
    }

    public double squareRoot(int n) throws RemoteException
    {
        return Math.sqrt(n);
    }
}