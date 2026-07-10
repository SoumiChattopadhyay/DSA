import java.util.Arrays;

public class Prog00_Array_Imp_programs {
    // Left Rotate array by 1 place
    // TC=O(N), SC=O(1)
    static int[] leftRotatebyOne(int[] arr, int n){
        int last = arr[0];
        for(int i=1;i<=n-1;i++){//Shift els from idx 1 to n-1 to the left TC=O(N)
            arr[i-1]=arr[i];
        }
        arr[n-1]=last;
        return arr;
    }
    // Left Rotate array by D places
    // Brute, TC=O(N+D), SC=O(D)
    static int[] leftRotatebyD_1(int[] arr, int n, int D){
        D%=n;
        int last[] = new int[D];
        for(int i=0;i<D;i++){//Copy first D els to another array, TC=O(D)
            last[i]=arr[i];
        }
        for(int i=D;i<n;i++){//Shift els from idx D to n-1 to the left, TC=O(N-D)
            arr[i-D]=arr[i];
        }
        for(int i=n-D;i<n;i++){//Add the copied D els to the last, TC=O(D)
            arr[i]=last[i-(n-D)];
        }
        return arr;
    }
    // Optimal, TC=O(N), SC=O(1)
    static int[] leftRotatebyD_2(int[] arr, int n, int D){
        D%=n;
        reverse(arr, 0, D-1);//Reverse first D els, TC=O(D)
        reverse(arr, D, n-1);//Reverse els from idx D to n-1, TC=O(N-D)
        reverse(arr, 0, n-1);//Reverse entire array, TC=O(N)
        return arr;
    }
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int n=arr.length;
        System.out.println(Arrays.toString(leftRotatebyOne(arr,n)));
        
        arr = new int[]{1,2,3,4,5,6,7};
        n=arr.length;
        System.out.println(Arrays.toString(leftRotatebyD_1(arr,n,2)));

        arr = new int[]{1,2,3,4,5,6,7};
        n=arr.length;
        System.out.println(Arrays.toString(leftRotatebyD_2(arr,n,2)));
    }
}
