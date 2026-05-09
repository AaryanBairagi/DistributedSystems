import java.rmi.Naming;

public class AddServer
{
    public static void main(String args[])
    {
        try
        {
            AddImpl obj = new AddImpl();

            Naming.rebind("rmi://localhost/AddService", obj);

            System.out.println("Addition Server Started");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}