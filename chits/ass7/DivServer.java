import java.rmi.Naming;

public class DivServer
{
    public static void main(String args[])
    {
        try
        {
            DivImpl obj = new DivImpl();

            Naming.rebind("rmi://localhost/DivService", obj);

            System.out.println("Division Server Started");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}