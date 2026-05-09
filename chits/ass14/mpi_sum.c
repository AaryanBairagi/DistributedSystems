#include<stdio.h>
#include<mpi.h>

int main(int argc, char *argv[])
{
    // Process ID and total number of processes
    int rank, size;

    // Input array
    int arr[8] = {1,2,3,4,5,6,7,8};

    // Partial sum calculated by each process
    int local_sum = 0;

    // Final combined sum
    int global_sum;

    // Initialize MPI Environment
    MPI_Init(&argc, &argv);

    // Get process rank (ID)
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    // Get total number of processes
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    // Divide work among processes
    for(int i = rank; i < 8; i += size)
    {
        local_sum += arr[i];
    }

    // Display partial sum of each process
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

    // Root process displays final result
    if(rank == 0)
    {
        printf("\nFinal Sum = %d\n", global_sum);
    }

    // End MPI Environment
    MPI_Finalize();

    return 0;
}


// to compile : mpicc mpi_sum.c -o mpi_sum
// to run : mpirun -np 4 ./mpi_sum