import java.rmi.registry.*;

public class Client {
    public static void main(String[] args) throws Exception {
        Calc obj = (Calc) LocateRegistry.getRegistry().lookup("CalcService");

        System.out.println("Add: " + obj.add(5, 3));
        System.out.println("Multiply: " + obj.multiply(5, 3));
    }
}