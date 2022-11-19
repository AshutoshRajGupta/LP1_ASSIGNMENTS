import java.util.Scanner;

public class Priority {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n = sc.nextInt();
        int i, pos=0, temp;

        System.out.println("Enter the burst times:");
        int p[] = new int[n];
        int bt[] = new int[n]; //burst time
        int pt[] = new int[n]; //priority time
        int wt[] = new int[n]; //waiting time
        int tat[] = new int[n]; //turn-around time

        for (i = 0; i < n; i++) {
            p[i] = i + 1;
            bt[i] = sc.nextInt();
        }

        System.out.println("Enter priority time:");
        for (i = 0; i < n; i++) {
            pt[i] = sc.nextInt();
        }
        
        // checking the priority
        for (i = 0; i < n; i++) {
            pos = i;
            for (int j = i + 1; j < n; j++) {
                if (pt[j] < pt[pos]) {
                    pos = j;
                }
            }
            
            //arranging gaant chart according to process , burts time and priority
            temp = pt[pos];
            pt[pos] = pt[i];
            pt[i] = temp;

            temp = p[pos];
            p[pos] = p[i];
            p[i] = temp;

            temp = bt[pos];
            bt[pos] = bt[i];
            bt[i] = temp;
        }

        wt[0] = 0;
        for (i = 1; i < n; i++) {
            //calculating waiting time
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        System.out.println("Process\tBT\tpriority\twaiting time\tTAT");

        for (i = 0; i < n; i++) {
            //calculating turn araound time
            tat[i] = bt[i] + wt[i];
            System.out.println(p[i] + "\t" + bt[i] + "\t" + pt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

    }
}
