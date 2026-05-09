import java.util.Scanner;

class SumThread extends Thread
{
    int arr[];
    int start, end;
    int localSum = 0;
    int threadNumber;

    SumThread(int arr[], int start, int end, int threadNumber)
    {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.threadNumber = threadNumber;
    }

    public void run()
    {
        for(int i = start; i < end; i++)
        {
            localSum += arr[i];
        }

        System.out.println(
        "Processor " + threadNumber +
        " Intermediate Sum = " + localSum);
    }

    public int getLocalSum()
    {
        return localSum;
    }
}

public class DistributedSum
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int arr[] = new int[n];

        System.out.println("Enter array elements:");

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter number of processors: ");
        int processors = sc.nextInt();

        SumThread threads[] = new SumThread[processors];

        int part = n / processors;
        int start = 0;

        for(int i = 0; i < processors; i++)
        {
            int end;

            if(i == processors - 1)
                end = n;
            else
                end = start + part;

            threads[i] =
            new SumThread(arr, start, end, i);

            threads[i].start();

            start = end;
        }

        int total = 0;

        try
        {
            for(int i = 0; i < processors; i++)
            {
                threads[i].join();

                total += threads[i].getLocalSum();
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        System.out.println(
        "\nFinal Sum = " + total);
    }
}