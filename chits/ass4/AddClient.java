import java.rmi.Naming;
import java.util.Scanner;

public class AddClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            AddInterface obj =
            (AddInterface) Naming.lookup("rmi://localhost/AddService");

            System.out.print("Enter First Number: ");
            int a = sc.nextInt();

            System.out.print("Enter Second Number: ");
            int b = sc.nextInt();

            System.out.println("Addition is: " + obj.add(a, b));
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}