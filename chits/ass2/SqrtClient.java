import java.rmi.Naming;
import java.util.Scanner;

public class SqrtClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            SqrtInterface obj =
                (SqrtInterface) Naming.lookup("rmi://localhost/SqrtService");

            System.out.print("Enter Number: ");
            int n = sc.nextInt();

            double result = obj.squareRoot(n);

            System.out.println("Square Root is: " + result);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}