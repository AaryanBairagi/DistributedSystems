import java.rmi.registry.*;

public class Server {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099).rebind("CalcService", new CalcImpl());
        System.out.println("Calculator RMI Server Ready");
    }
}