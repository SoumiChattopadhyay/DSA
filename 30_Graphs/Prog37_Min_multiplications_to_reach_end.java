// Given start, end and an array arr of n numbers. 
// At each step, start is multiplied with any number in the array 
// and then mod operation with 100000 is done to get the new start. 
// Your task is to find the minimum steps in which end can be achieved 
// starting from start. If it is not possible to reach end, then return -1. 
import java.util.LinkedList; 
import java.util.Queue; 
class Pair{ 
    int node; 
    int mulSteps; 
    Pair(int mulSteps,int node){ 
        this.mulSteps=mulSteps; 
        this.node=node; 
    } 
}
public class Prog37_Min_multiplications_to_reach_end {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        if(start==end){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,start));
        
        int dist[]=new int[100000];
        for(int i=0;i<=99999;i++) dist[i] = (int)1e9;
            dist[start]=0;
        
        while(!q.isEmpty()){
            Pair it=q.poll();
            int node=it.node;
            int mulSteps=it.mulSteps;
            for(int el:arr){
                int neighbor=(node*el)%100000;
                if(mulSteps+1<dist[neighbor]){
                    dist[neighbor]=mulSteps+1;
                    if(neighbor==end)return mulSteps+1;
                    q.add(new Pair(mulSteps+1,neighbor));
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 65};
        int start = 7, end = 66175;
        System.out.println(minimumMultiplications(arr, start, end));
    }    
}
