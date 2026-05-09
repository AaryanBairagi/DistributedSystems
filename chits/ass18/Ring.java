import java.util.Scanner;

public class Ring
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int process[] = new int[n];

        System.out.println("Enter process IDs:");

        for(int i = 0; i < n; i++)
        {
            process[i] = sc.nextInt();
        }

        int max = process[0];

        for(int i = 1; i < n; i++)
        {
            if(process[i] > max)
            {
                max = process[i];
            }
        }

        System.out.println(
        "Coordinator is Process " + max);
    }
}