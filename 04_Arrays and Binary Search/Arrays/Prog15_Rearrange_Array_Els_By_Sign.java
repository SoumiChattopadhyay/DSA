import java.util.Arrays;

public class Prog15_Rearrange_Array_Els_By_Sign {
    // Brute soln
    static int[] funct1(int[] arr, int n){
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];
        // Storing values in pos and neg arrays O(N)
        int p=0,k=0;
        for(int i=0;i<n;i++){
            if(arr[i]>0) pos[p++]=arr[i];
            if(arr[i]<0) neg[k++]=arr[i];
        }
        // Rearranging arr (Reassigning values to it) O(N/2)
        for(int i=0;i<n/2;i++){
            arr[2*i]=pos[i];
            arr[2*i+1]=neg[i];
        }
        return arr;
    }
    // i -> 2*i, 2*i+1
    // 0 -> 0,1
    // 1 -> 2,3
    // 2 -> 4,5
    // 3 -> 6,7

    // Optimal soln
    static int[] funct2(int[] arr, int n){
        int posIdx=0;
        int negIdx=1;
        int[] ans = new int[n];
        // Traversing arr and storing rearranged values in ans array O(N)
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                ans[i]=arr[posIdx];
                posIdx+=2;
            }
            else{
                ans[i]=arr[negIdx];
                negIdx+=2;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};//array will always have n/2 pos and n/2 neg els. and will never have 0
        int n = arr.length;
        System.out.println(Arrays.toString(funct1(arr, n)));
        System.out.println(Arrays.toString(funct2(arr, n)));
    }
}
