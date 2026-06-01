import java.util.ArrayList;
import java.util.List;

public class Prog18_Leaders_in_Array {
    // Optimal Solution, TC=O(N) or O(NlogN), SC=O(N)
    static List<Integer> funct2(int[] arr){
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        int maxi=Integer.MIN_VALUE;

        for(int i=n-1;i>=0;i--){
            if(arr[i]>maxi){
                leaders.add(arr[i]);
            }
            maxi=Math.max(maxi,arr[i]);//keep track of right maximum
        }

        return leaders;
    }
    // Brute Force, TC=O(N^2), SC=O(N)
    static List<Integer> funct1(int[] arr){
        int n = arr.length;
        List<Integer> leaders = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            boolean isLeader=true;
            for(int j=i+1;j<n;j++){
                if(arr[i]<arr[j]){
                    isLeader=false;
                    break;
                }
            }
            if(isLeader) 
                leaders.add(arr[i]);
        }

        return leaders;
    }
    public static void main(String[] args) {
        int[] arr = {10,22,12,3,0,6};
        System.out.println(funct1(arr));
        System.out.println(funct2(arr));
    }
}