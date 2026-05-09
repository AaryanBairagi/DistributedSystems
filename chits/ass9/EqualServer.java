import java.rmi.Naming;

public class EqualServer
{
    public static void main(String args[])
    {
        try
        {
            EqualImpl obj = new EqualImpl();

            Naming.rebind("rmi://localhost/EqualService", obj);

            System.out.println("String Equality Server Started");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}