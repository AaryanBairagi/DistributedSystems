import java.rmi.server.*;
import java.rmi.*;

public class MulImpl extends UnicastRemoteObject
implements MulInterface
{
    protected MulImpl() throws RemoteException
    {
        super();
    }

    public int multiply(int a, int b) throws RemoteException
    {
        return a * b;
    }
}