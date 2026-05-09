import java.rmi.Naming;
import java.util.Scanner;

public class EqualClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            EqualInterface obj =
            (EqualInterface) Naming.lookup(
            "rmi://localhost/EqualService");

            System.out.print("Enter First String: ");
            String s1 = sc.nextLine();

            System.out.print("Enter Second String: ");
            String s2 = sc.nextLine();

            System.out.println(obj.checkEqual(s1, s2));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}