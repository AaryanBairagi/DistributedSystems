import java.rmi.Naming;

public class SqrtServer
{
    public static void main(String args[])
    {
        try
        {
            SqrtImpl obj = new SqrtImpl();

            Naming.rebind("rmi://localhost/SqrtService", obj);

            System.out.println("Square Root RMI Server Started...");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}