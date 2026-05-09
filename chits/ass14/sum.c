#include <stdio.h>
#include <omp.h>

int main()
{
    int a[100], n, sum = 0;

    printf("Enter number of elements: ");
    scanf("%d", &n);

    printf("Enter array elements:\n");

    for(int i = 0; i < n; i++)
    {
        scanf("%d", &a[i]);
    }

    #pragma omp parallel
    {
        int local_sum = 0;

        #pragma omp for
        for(int i = 0; i < n; i++)
        {
            local_sum += a[i];
        }

        printf("Processor %d Local Sum = %d\n",
               omp_get_thread_num(), local_sum);

        #pragma omp atomic
        sum += local_sum;
    }

    printf("Total Sum = %d\n", sum);

    return 0;
}