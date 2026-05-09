import java.rmi.server.*;
import java.rmi.*;

public class SquareImpl extends UnicastRemoteObject
implements SquareInterface
{
    protected SquareImpl() throws RemoteException
    {
        super();
    }

    public int square(int n) throws RemoteException
    {
        return n * n;
    }
}