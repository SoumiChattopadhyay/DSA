// import java.util.Arrays;
public class Prog16_Partition_Equal_Subset_Sum {
    static boolean funct4(int N, int K, int[] arr){
        boolean[] prevRow= new boolean[K+1];
        boolean[] currRow=new boolean[K+1];
        // Base Cases
        prevRow[0]=currRow[0]=true;//if target=0 return true case
        if(arr[0]<=K) prevRow[arr[0]]=true;//if ind=0 return (arr[0]==target?true:false) case

        for(int ind=1;ind<=N-1;ind++){
            currRow = new boolean[K+1];   // reset
            currRow[0] = true;
            for(int target=1;target<=K;target++){
                boolean nottake = prevRow[target];
                boolean take = false;
                if(target>=arr[ind]){
                    take = prevRow[target-arr[ind]];
                }
                currRow[target] = nottake || take;
            }
            // System.out.println(Arrays.toString(currRow));
            prevRow=currRow;
        }

        return prevRow[K];
    }
    static boolean check(int[] arr){
        int totalSum=0;
        
        // Find total sum(S)
        for(int i=0;i<arr.length;i++){
            totalSum+=arr[i];
        }
        if(totalSum%2!=0) return false;
        
        int target = totalSum/2;
        return funct4(arr.length,target,arr);
    }
    public static void main(String[] args) {
        int[] arr = {2,3,3,3,4,5};
        
        System.out.println(check(arr));
    }
}
