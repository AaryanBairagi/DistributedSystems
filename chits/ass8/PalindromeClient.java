import java.rmi.Naming;
import java.util.Scanner;

public class PalindromeClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            PalindromeInterface obj =
            (PalindromeInterface) Naming.lookup(
            "rmi://localhost/PalindromeService");

            System.out.print("Enter String: ");
            String str = sc.nextLine();

            System.out.println(obj.palindrome(str));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}