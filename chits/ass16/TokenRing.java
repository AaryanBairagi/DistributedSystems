import java.util.Scanner;

public class TokenRing
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        // Number of processes
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        // Initial token holder
        int token = 0;

        // Process creation
        System.out.println("\nProcesses Created:");

        for(int i = 0; i < n; i++)
        {
            System.out.println("Process " + i);
        }

        int choice;

        do
        {
            // Process requesting CS
            System.out.print(
            "\nEnter process number requesting Critical Section: ");

            int sender = sc.nextInt();

            // Pass token until requesting process gets it
            while(token != sender)
            {
                System.out.println(
                "Token passed from Process "
                + token + " to Process "
                + ((token + 1) % n));

                token = (token + 1) % n;
            }

            // Process enters CS
            System.out.println(
            "\nProcess " + sender +
            " ENTERED Critical Section");

            // Actual critical section work
            System.out.print(
            "Enter receiver process number: ");

            int receiver = sc.nextInt();

            sc.nextLine();

            System.out.print(
            "Enter message to send: ");

            String message = sc.nextLine();

            // Simulated data transfer
            System.out.println(
            "\nProcess " + sender +
            " sending message to Process "
            + receiver);

            System.out.println(
            "Message: " + message);

            System.out.println(
            "Process " + receiver +
            " received message successfully");

            // Leaving CS
            System.out.println(
            "\nProcess " + sender +
            " LEFT Critical Section");

            // Pass token to next process
            token = (token + 1) % n;

            System.out.println(
            "Token passed to Process " + token);

            // Continue option
            System.out.print(
            "\nContinue? (1/0): ");

            choice = sc.nextInt();

        } while(choice == 1);

        sc.close();
    }
}