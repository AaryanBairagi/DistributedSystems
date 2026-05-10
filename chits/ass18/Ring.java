import java.util.*;

public class Ring {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int process[] = new int[n];
        boolean active[] = new boolean[n];

        // Input process IDs
        for(int i = 0; i < n; i++) {

            System.out.print("Enter Process ID: ");
            process[i] = sc.nextInt();

            active[i] = true;
        }

        // Assume highest process crashes
        active[n - 1] = false;

        System.out.println(
            "Process " + process[n - 1] +
            " has crashed!"
        );

        // Election initiator
        System.out.print(
            "Enter process initiating election: "
        );

        int initiator = sc.nextInt();

        ArrayList<Integer> electionList =
                new ArrayList<>();

        int current = initiator;

        System.out.println("\nElection Message Passing:\n");

        do {

            if(active[current]) {

                electionList.add(process[current]);

                System.out.println(
                    "Process " + process[current] +
                    " passes message"
                );
            }

            current = (current + 1) % n;

        } while(current != initiator);

        // Find highest active process
        int coordinator =
                Collections.max(electionList);

        System.out.println(
            "\nNew Coordinator is Process "
            + coordinator
        );

        System.out.println(
            "Coordinator message circulated in ring"
        );
    }
}