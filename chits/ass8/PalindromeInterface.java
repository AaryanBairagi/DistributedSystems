import java.rmi.*;

public interface PalindromeInterface extends Remote
{
    public String palindrome(String str) throws RemoteException;
}