import java.util.Arrays;

public class Prog00_Array_Imp_programs {
    // Left Rotate array by 1 place
    // TC=O(N), SC=O(1)
    static int[] leftRotatebyOne_1(int[] arr, int n){
        int last = arr[0];
        for(int i=1;i<=n-1;i++){//Shift els from idx 1 to n-1 to the left TC=O(N)
            arr[i-1]=arr[i];
        }
        arr[n-1]=last;
        return arr;
    }
    
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n=arr.length;
        System.out.println(Arrays.toString(leftRotatebyOne_1(arr,n)));
    }
}
