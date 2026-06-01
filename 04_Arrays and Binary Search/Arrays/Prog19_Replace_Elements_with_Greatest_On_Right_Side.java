import java.util.Arrays;

public class Prog19_Replace_Elements_with_Greatest_On_Right_Side {
    static int[] replaceElements(int[] arr) {
        int n = arr.length;
        int maxi=arr[n-1];

        for(int i=n-2;i>=0;i--){
            int temp = arr[i];   // store original value
            arr[i] = maxi;       // replace with right max
            maxi = Math.max(maxi, temp); // update using original
        }

        arr[n-1]=-1;

        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        System.out.println(Arrays.toString(replaceElements(arr)));
    }
}
