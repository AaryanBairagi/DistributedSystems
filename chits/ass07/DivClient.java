import java.rmi.Naming;
import java.util.Scanner;

public class DivClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            DivInterface obj =
            (DivInterface) Naming.lookup("rmi://localhost/DivService");

            System.out.print("Enter First Number: ");
            int a = sc.nextInt();

            System.out.print("Enter Second Number: ");
            int b = sc.nextInt();

            System.out.println("Division is: " + obj.divide(a, b));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}