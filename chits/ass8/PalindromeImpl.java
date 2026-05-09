import java.rmi.server.*;
import java.rmi.*;

public class PalindromeImpl extends UnicastRemoteObject
implements PalindromeInterface
{
    protected PalindromeImpl() throws RemoteException
    {
        super();
    }

    public String palindrome(String str) throws RemoteException
    {
        String rev = "";

        for(int i = str.length()-1; i >= 0; i--)
        {
            rev = rev + str.charAt(i);
        }

        if(str.equals(rev))
            return "Palindrome";
        else
            return "Not Palindrome";
    }
}
