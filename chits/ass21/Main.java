package multiplicationclient;

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

        int result = multiply(a, b);

        System.out.println("Multiplication = " + result);
    }

    private static int multiply(int a, int b)
    {
        com.mul.MulService_Service service =
        new com.mul.MulService_Service();

        com.mul.MulService port =
        service.getMulServicePort();

        return port.multiply(a, b);
    }
}