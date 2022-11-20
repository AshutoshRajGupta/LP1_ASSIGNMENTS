import java.util.Scanner;
public class best_fit{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of partitions");
        int npart = sc.nextInt();
        System.out.println("Enter size of partitions: ");
        int part[] = new int[npart];
        for(int i =0;i<npart;i++){
            part[i] = sc.nextInt();
        }

        System.out.println("Enter number of processes");
        int nproc = sc.nextInt();
        System.out.print("Enter size of processes: ");
        int proc[] = new int[nproc];
        for(int i =0;i<nproc;i++){
            proc[i] = sc.nextInt();
        }

        int filled[] = new int[npart];

        for(int i =0;i<nproc;i++){
            int k = -1;
            for(int j = 0;j<npart;j++){
                if(part[j]>=proc[i]){
                    if((k==-1||part[j]<part[k])&&filled[j]!=1){
                        k = j;
                    }
                }
            }
            if(k!=-1){
                filled[k] = 1;
                System.out.println("Best Fit for process "+proc[i]+" is "+part[k]+" and Hole of "+(part[k]-proc[i])+" is created.");
            }
            else{
                System.out.println("Best fit not found");
            }
        }
    }
}
