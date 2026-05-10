#include<stdio.h>
#include<mpi.h>

int main(int argc, char *argv[])
{
    // Process ID and total number of processes
    int rank, size;

    // Array size
    int n;

    // Partial sum of each process
    int local_sum = 0;

    // Final total sum
    int global_sum;

    // Initialize MPI
    MPI_Init(&argc, &argv);

    // Get process rank
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    // Get total number of processes
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Root process takes array size input
    if(rank == 0)
    {
        printf("Enter array size: \n");
        fflush(stdout);
        scanf("%d", &n);
    }

    // Broadcast array size to all processes
    MPI_Bcast(&n, 1, MPI_INT, 0, MPI_COMM_WORLD);

    // Dynamic array
    int arr[n];

    // Root process takes array elements
    if(rank == 0)
    {
        printf("Enter %d elements of the array:\n", n);

        for(int i = 0; i < n; i++)
        {
            scanf("%d", &arr[i]);
        }
    }

    // Broadcast array to all processes
    MPI_Bcast(arr, n, MPI_INT, 0, MPI_COMM_WORLD);

    // Divide work among processes
    for(int i = rank; i < n; i += size)
    {
        local_sum += arr[i];
    }

    // Display partial sum
    printf("Process %d calculated partial sum = %d\n",
            rank, local_sum);

    // Combine all local sums into global sum
    MPI_Reduce(
        &local_sum,     // Send buffer
        &global_sum,    // Receive buffer
        1,              // Number of elements
        MPI_INT,        // Datatype
        MPI_SUM,        // Operation
        0,              // Root process
        MPI_COMM_WORLD  // Communicator
    );

    // Root process prints final result
    if(rank == 0)
    {
        printf("\nFinal Sum = %d\n", global_sum);
    }

    // End MPI environment
    MPI_Finalize();

    return 0;
}

//To check MPI: mpicc --version

//To compile: mpicc mpi_sum.c -o mpi_sum

//To run: mpirun -np 4 ./mpi_sum