import java.rmi.Naming;

public class MulServer
{
    public static void main(String args[])
    {
        try
        {
            MulImpl obj = new MulImpl();

            Naming.rebind("rmi://localhost/MulService", obj);

            System.out.println("Multiplication Server Started");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}