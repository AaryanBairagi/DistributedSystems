import java.rmi.Naming;
import java.util.Scanner;

public class CubeClient
{
    public static void main(String args[])
    {
        try
        {
            Scanner sc = new Scanner(System.in);

            CubeInterface obj =
                (CubeInterface) Naming.lookup("rmi://localhost/CubeService");

            System.out.print("Enter Number: ");
            int n = sc.nextInt();

            int result = obj.cube(n);

            System.out.println("Cube is: " + result);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}