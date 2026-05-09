import java.util.Scanner;

public class Bully
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int n;

        System.out.print("Enter number of processes: ");
        n = sc.nextInt();

        int processes[] = new int[n];

        System.out.println("Enter process IDs:");

        for(int i = 0; i < n; i++)
        {
            processes[i] = sc.nextInt();
        }

        System.out.print("Enter failed coordinator: ");
        int fail = sc.nextInt();

        int coordinator = -1;

        for(int i = 0; i < n; i++)
        {
            if(processes[i] != fail)
            {
                coordinator = Math.max(coordinator,
                                       processes[i]);
            }
        }

        System.out.println(
        "New Coordinator is Process " + coordinator);
    }
}