import java.rmi.Naming;

public class PalindromeServer
{
    public static void main(String args[])
    {
        try
        {
            PalindromeImpl obj = new PalindromeImpl();

            Naming.rebind("rmi://localhost/PalindromeService", obj);

            System.out.println("Palindrome Server Started");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}