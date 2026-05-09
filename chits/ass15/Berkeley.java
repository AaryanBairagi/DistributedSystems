import java.util.Scanner;

public class Berkeley
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n;
        int sum = 0;

        // Number of clocks
        System.out.print("Enter number of clocks: ");
        n = sc.nextInt();

        int clock[] = new int[n];

        // Input clock times
        System.out.println("Enter clock times:");

        for(int i = 0; i < n; i++)
        {
            System.out.print("Clock " + (i + 1) + ": ");
            clock[i] = sc.nextInt();

            sum += clock[i];
        }

        // Calculate average time
        int avg = sum / n;

        System.out.println("\nAverage Time = " + avg);

        // Synchronize clocks
        System.out.println("\nSynchronizing clocks...");

        for(int i = 0; i < n; i++)
        {
            int difference = avg - clock[i];

            System.out.println(
            "Clock " + (i + 1) +
            " adjusted by " + difference);

            // Updating the clock
            clock[i] = avg;
        }

        // Display synchronized clocks
        System.out.println("\nSynchronized Clocks:");

        for(int i = 0; i < n; i++)
        {
            System.out.println(
            "Clock " + (i + 1) +
            " -> " + clock[i]);
        }

        sc.close();
    }
}