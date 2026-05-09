import java.rmi.Naming;

public class CubeServer
{
    public static void main(String args[])
    {
        try
        {
            CubeImpl obj = new CubeImpl();

            Naming.rebind("rmi://localhost/CubeService", obj);

            System.out.println("Cube RMI Server Started...");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
}