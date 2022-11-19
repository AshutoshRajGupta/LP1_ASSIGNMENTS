
----------------------------------------------------------------------------------------------------------------------------------------------
    import java.util.Scanner;
 
public class priority{
        
    public static void main(String args[]) {
            Scanner s = new Scanner(System.in);
 
            int x,n,p[],pp[],bt[],w[],t[],awt,atat,i;
 
            p = new int[10];
            pp = new int[10];
            bt = new int[10];
            w = new int[10];
            t = new int[10];
 
   //n is number of process
   //p is process
   //pp is process priority
   //bt is process burst time
   //w is wait time
   // t is turnaround time
   //awt is average waiting time
   //atat is average turnaround time
 
 
   System.out.print("Enter the number of process : ");
   n = s.nextInt();
    System.out.print("\n\t Enter burst time : time priorities \n");
 
   for(i=0;i<n;i++)
    {
       System.out.print("\nProcess["+(i+1)+"]:");
      bt[i] = s.nextInt();
      pp[i] = s.nextInt();
      p[i]=i+1;
    }
 
//sorting on the basis of priority
  for(i=0;i<n-1;i++)
   {
     for(int j=i+1;j<n;j++)
     {
       if(pp[i]>pp[j])
       {
     x=pp[i];
     pp[i]=pp[j];
     pp[j]=x;
     x=bt[i];
     bt[i]=bt[j];
     bt[j]=x;
     x=p[i];
     p[i]=p[j];
     p[j]=x;
      }
   }
}
w[0]=0;
awt=0;
t[0]=bt[0];
atat=t[0];
for(i=1;i<n;i++)
 {
   w[i]=t[i-1];
   awt+=w[i];
   t[i]=w[i]+bt[i];
   atat+=t[i];
 }
 
//Displaying the process
 
  System.out.print("\n\nProcess \t Burst Time \t Wait Time \t Turn Around Time   Priority \n");
for(i=0;i<n;i++)
  System.out.print("\n   "+p[i]+"\t\t   "+bt[i]+"\t\t     "+w[i]+"\t\t     "+t[i]+"\t\t     "+pp[i]+"\n");
awt/=n;
atat/=n;
  System.out.print("\n Average Wait Time : "+awt);
  System.out.print("\n Average Turn Around Time : "+atat);
 
        }
}


/*******OUTPUT********

Enter the number of process : 5

  Enter burst time : time priorities 

Process[1]:7 2

Process[2]:6 4

Process[3]:4 1

Process[4]:5 3

Process[5]:1 0


Process   Burst Time   Wait Time   Turn Around Time   Priority 

   5     1       0       1       0

   3     4       1       5       1

   1     7       5       12       2

   4     5       12       17       3

   2     6       17       23       4

 Average Wait Time : 7
 Average Turn Around Time : 11

************************/

------------------------------------------------------------------------------------------------------------------------
    
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

        for (i = 0; i < n; i++) {
            pos = i;
            for (int j = i + 1; j < n; j++) {
                if (pt[j] < pt[pos]) {
                    pos = j;
                }
            }
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

        /*for(i=1;i<n;i++)
        {
            wt[i]=0;
            for(int j=0;j<i;j++)
                wt[i]+=bt[j];
        }*/
        for (i = 1; i < n; i++) {
            wt[i] = wt[i - 1] + bt[i - 1];
        }

        System.out.println("Process\tBT\tpriority\twaiting time\tTAT");

        for (i = 0; i < n; i++) {
            tat[i] = bt[i] + wt[i];
            System.out.println(p[i] + "\t" + bt[i] + "\t" + pt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
        }

    }
}
