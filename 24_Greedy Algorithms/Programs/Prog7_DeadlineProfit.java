import java.util.ArrayList;
import java.util.Collections;

public class Prog7_DeadlineProfit {
    static class Job{
        int deadline;
        int profit;
        int id;
        public Job(int d, int p, int i){
            deadline=d;
            profit=p;
            id=i;
        }
    }
    public static void main(String[] args) {
        int arr[][] = {{4,20},{1,10},{1,40},{1,30}};//{deadline,profit}
        // int arr2[]=new int[5];
        // Job arr[]=new Job[arr.length];//array of objects of Job class. This statement only declares and allocates memory for the array, but it does not create actual Job objects inside it
        // for(int i=0;i<arr.length;i++){
        //     arr[i]=new Job(arr[i][0],arr[i][1],i);
        // }
        ArrayList<Job> jobs = new ArrayList<>();//ArrayList of objects of Job class
        for(int i=0;i<arr.length;i++){
            jobs.add(new Job(arr[i][0],arr[i][1],i));
        }
        Collections.sort(jobs,(a,b)->b.profit-a.profit);//sorts the ArrayList in Descending order of profit
        ArrayList<Character> seq = new ArrayList<>();//stores the jobs that can be done in a sequence
        int deadline=0, maxProfit=0;
        int alph=65;
        for(int i=0;i<jobs.size();i++){
            Job curr = jobs.get(i);
            if(curr.deadline>deadline){
                deadline++;
                seq.add((char)alph);
                maxProfit+=curr.profit;
            }
            alph++;
        }
        for(int i=0;i<seq.size();i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
        System.out.println("Time taken to complete = "+deadline);
        System.err.println("Max profit = "+maxProfit);
    }
}
//Task with lesser deadline and maximum profit must be done first while task with greater deadline can be done later. 
//So we sort the ArrayList based on the profit