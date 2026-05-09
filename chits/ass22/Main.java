package divisionclient;

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

        float result = divide(a, b);

        System.out.println("Division = " + result);
    }

    private static float divide(int a, int b)
    {
        com.div.DivService_Service service =
        new com.div.DivService_Service();

        com.div.DivService port =
        service.getDivServicePort();

        return port.divide(a, b);
    }
}