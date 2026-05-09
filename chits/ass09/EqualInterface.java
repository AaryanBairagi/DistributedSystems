import java.rmi.*;

public interface EqualInterface extends Remote
{
    public String checkEqual(String s1, String s2)
    throws RemoteException;
}