import java.rmi.Naming;
import java.util.Scanner;

public class MulClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            MulInterface obj =
            (MulInterface) Naming.lookup("rmi://localhost/MulService");

            System.out.print("Enter First Number: ");
            int a = sc.nextInt();

            System.out.print("Enter Second Number: ");
            int b = sc.nextInt();

            System.out.println("Multiplication is: " + obj.multiply(a, b));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}