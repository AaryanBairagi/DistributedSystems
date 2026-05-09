import java.rmi.Naming;
import java.util.Scanner;

public class SquareClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            SquareInterface obj =
            (SquareInterface) Naming.lookup("rmi://localhost/SquareService");

            System.out.print("Enter Number: ");
            int n = sc.nextInt();

            System.out.println("Square is: " + obj.square(n));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}