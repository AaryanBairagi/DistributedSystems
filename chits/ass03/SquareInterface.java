import java.rmi.*;

public interface SquareInterface extends Remote
{
    public int square(int n) throws RemoteException;
}