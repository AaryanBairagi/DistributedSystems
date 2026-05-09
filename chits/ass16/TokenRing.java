import java.util.Scanner;

public class TokenRing
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int token = 0;

        for(int i = 0; i < n; i++)
        {
            System.out.println(
            "Process " + i + " has token");
        }

        int choice;

        do
        {
            System.out.print("\nEnter process number to access CS: ");
            int p = sc.nextInt();

            while(token != p)
            {
                System.out.println(
                "Token passed to process " + token);

                token = (token + 1) % n;
            }

            System.out.println(
            "Process " + p + " entering Critical Section");

            System.out.println(
            "Process " + p + " leaving Critical Section");

            System.out.print("\nContinue? (1/0): ");
            choice = sc.nextInt();

        } while(choice == 1);
    }
}