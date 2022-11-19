/*output-
enter no of process: 
3
enter process 1 arrival time: 
0
enter process 1 brust time: 
9
enter process 2 arrival time: 
1
enter process 2 brust time: 
4
enter process 3 arrival time: 
2
enter process 3 brust time: 
9

pid  arrival  brust  complete turn waiting
1        0      9       9       9       0
2        1      4       13      12      8
3        2      9       22      20      11

average waiting time: 6.3333335
average turnaround time:13.666667
*/
-------------------------------------------------------------------------------------------------------------------------------------------------
    
import java.util.*;

public class fcfs {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter no of process: ");
        int n = sc.nextInt();
        int pid[] = new int[n]; // process ids
        int ar[] = new int[n]; // arrival times
        int bt[] = new int[n]; // burst or execution times
        int ct[] = new int[n]; // completion times
        int ta[] = new int[n]; // turn around times
        int wt[] = new int[n]; // waiting times
        int temp;
        float avgwt = 0, avgta = 0;

        System.out.println("\nEnter Burst Time for processes:");
        for(int i=0;i<n;i++)
        {
            System.out.print("\tP"+(i+1)+":  ");
            bt[i]=sc.nextInt();
        }

        System.out.println("\nEnter Arival Time for processes:");
        for(int i=0;i<n;i++)
        {
            System.out.print("\tP"+(i+1)+":  ");
            ar[i]=sc.nextInt();
        }
        
        // finding completion times
        for (int i = 0; i < n; i++) {
            //for zero arrival time
            if (i == 0) {
                ct[i] = ar[i] + bt[i];
            } else {
                //if arrival time greater than completion time
                if (ar[i] > ct[i - 1]) {
                    ct[i] = ar[i] + bt[i];
                } else
                    ct[i] = ct[i - 1] + bt[i];
            }
            ta[i] = ct[i] - ar[i]; // turnaround time= completion time- arrival time
            wt[i] = ta[i] - bt[i]; // waiting time= turnaround time- burst time
            avgwt += wt[i]; // total waiting time
            avgta += ta[i]; // total turnaround time
        }
        System.out.println("\npid  arrival  brust  complete turn waiting");
        for (int i = 0; i < n; i++) {
            System.out.println(pid[i] + "  \t " + ar[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        sc.close();
        System.out.println("\naverage waiting time: " + (avgwt / n)); // printing average waiting time.
        System.out.println("average turnaround time:" + (avgta / n)); // printing average turnaround time.
    }
}
