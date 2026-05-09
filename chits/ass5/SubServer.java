import java.rmi.Naming;

public class SubServer
{
    public static void main(String args[])
    {
        try
        {
            SubImpl obj = new SubImpl();

            Naming.rebind("rmi://localhost/SubService", obj);

            System.out.println("Subtraction Server Started");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}