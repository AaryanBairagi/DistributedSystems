package subtractionclient;

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

        int result = subtract(a, b);

        System.out.println("Subtraction = " + result);
    }

    private static int subtract(int a, int b)
    {
        com.sub.SubService_Service service =
        new com.sub.SubService_Service();

        com.sub.SubService port =
        service.getSubServicePort();

        return port.subtract(a, b);
    }
}