package additionclient;

import java.util.Scanner;

public class Main
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int a, b;

        System.out.print("Enter First Number: ");
        a = sc.nextInt();

        System.out.print("Enter Second Number: ");
        b = sc.nextInt();

        int result = add(a, b);

        System.out.println("Addition = " + result);
    }

    private static int add(int a, int b)
    {
        com.add.AddService_Service service =
        new com.add.AddService_Service();

        com.add.AddService port =
        service.getAddServicePort();

        return port.add(a, b);
    }
}