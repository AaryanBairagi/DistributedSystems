import java.util.Scanner;

public class Berkeley
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n;
        int sum = 0;

        System.out.print("Enter number of clocks: ");
        n = sc.nextInt();

        int clock[] = new int[n];

        System.out.println("Enter clock times:");

        for(int i = 0; i < n; i++)
        {
            clock[i] = sc.nextInt();
            sum += clock[i];
        }

        int avg = sum / n;

        System.out.println("\nAverage Time: " + avg);

        System.out.println("\nSynchronized Clocks:");

        for(int i = 0; i < n; i++)
        {
            System.out.println(
            "Clock " + (i+1) + " -> " + avg);
        }
    }
}