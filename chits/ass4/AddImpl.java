import java.rmi.server.*;
import java.rmi.*;

public class AddImpl extends UnicastRemoteObject
implements AddInterface
{
    protected AddImpl() throws RemoteException
    {
        super();
    }

    public int add(int a, int b) throws RemoteException
    {
        return a + b;
    }
}