import java.rmi.server.*;
import java.rmi.*;

public class SubImpl extends UnicastRemoteObject
implements SubInterface
{
    protected SubImpl() throws RemoteException
    {
        super();
    }

    public int sub(int a, int b) throws RemoteException
    {
        return a - b;
    }
}