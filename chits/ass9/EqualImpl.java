import java.rmi.server.*;
import java.rmi.*;

public class EqualImpl extends UnicastRemoteObject
implements EqualInterface
{
    protected EqualImpl() throws RemoteException
    {
        super();
    }

    public String checkEqual(String s1, String s2)
    throws RemoteException
    {
        if(s1.equals(s2))
            return "Strings are Equal";
        else
            return "Strings are Not Equal";
    }
}