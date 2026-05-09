import java.rmi.server.*;
import java.rmi.*;

public class DivImpl extends UnicastRemoteObject
implements DivInterface
{
    protected DivImpl() throws RemoteException
    {
        super();
    }

    public float divide(int a, int b) throws RemoteException
    {
        return (float)a / b;
    }
}