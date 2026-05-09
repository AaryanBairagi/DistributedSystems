import java.rmi.Naming;
import java.util.Scanner;

public class SubClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            SubInterface obj =
            (SubInterface) Naming.lookup("rmi://localhost/SubService");

            System.out.print("Enter First Number: ");
            int a = sc.nextInt();

            System.out.print("Enter Second Number: ");
            int b = sc.nextInt();

            System.out.println("Subtraction is: " + obj.sub(a, b));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}