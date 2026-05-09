import java.rmi.Naming;

public class SquareServer
{
    public static void main(String args[])
    {
        try
        {
            SquareImpl obj = new SquareImpl();

            Naming.rebind("rmi://localhost/SquareService", obj);

            System.out.println("Square Server Started");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}