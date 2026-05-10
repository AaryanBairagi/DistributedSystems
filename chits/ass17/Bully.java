import java.util.*;

class Bully {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int processes[] = new int[n];
        boolean active[] = new boolean[n];

        // Input processes
        for(int i = 0; i < n; i++) {

            System.out.print("Enter Process ID: ");
            processes[i] = sc.nextInt();

            active[i] = true;
        }

        // Current coordinator
        int coordinator = processes[n - 1];

        System.out.println(
            "Current Coordinator is Process "
            + coordinator
        );

        // Crash coordinator
        active[n - 1] = false;

        System.out.println(
            "Process " + coordinator + " has crashed!"
        );

        // Election initiator
        System.out.print(
            "Enter process initiating election: "
        );

        int initiator = sc.nextInt();

        int newCoordinator = initiator;

        System.out.println("\nElection Started...\n");

        for(int i = 0; i < n; i++) {

            if(processes[i] > initiator && active[i]) {

                System.out.println(
                    "Process " + initiator +
                    " sends ELECTION message to Process "
                    + processes[i]
                );

                System.out.println(
                    "Process " + processes[i] +
                    " sends OK message"
                );

                newCoordinator = processes[i];
            }
        }

        System.out.println(
            "\nProcess " + newCoordinator +
            " becomes NEW COORDINATOR"
        );

        System.out.println(
            "Coordinator message sent to all processes"
        );
    }
}