import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prog16_Rearrange_Array_Els_By_Sign_II {
    // Brute soln
    static int[] funct1(int[] arr, int n){
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        // Store values in pos and neg lists O(n)
        for(int i=0;i<n;i++){
            if(arr[i]>0) 
                pos.add(arr[i]);
            else 
                neg.add(arr[i]);
        }

        // If no. of pos els > no. of neg els. O(n)
        if(pos.size()>neg.size()){
            for(int i=0;i<neg.size();i++){
                arr[2*i]=pos.get(i);
                arr[2*i+1]=neg.get(i);
            }
            int ind=2*neg.size();
            for(int i=neg.size();i<pos.size();i++){
                arr[ind]=pos.get(i);
                ind++;
            }
        }
        // If no. of neg els > no. of pos els. O(n)
        else{
            for(int i=0;i<pos.size();i++){
                arr[2*i]=pos.get(i);
                arr[2*i+1]=neg.get(i);
            }
            int ind=2*pos.size();
            for(int i=pos.size();i<neg.size();i++){
                arr[ind]=neg.get(i);
                ind++;
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {-1,2,3,4,-3,1};//array can have any no. of pos and neg els. and will never have 0
        int n = arr.length;
        System.out.println(Arrays.toString(funct1(arr, n)));
    }
}
