import java.util.ArrayList;
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
    // Move zeroes to end
    // Brute, TC=O(N)
    static void move0sToEnd_1(int[] arr, int n){
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i=0;i<n;i++){//copy non-zero els to another list. We took list becoz we dont know the exact size
            if(arr[i]!=0){
                temp.add(arr[i]);
            }
        }
        int k=temp.size();
        for(int i=0;i<k;i++){//put the copied els in the front of the array
            arr[i]=temp.get(i);
        }
        for(int i=k;i<n;i++){//fill remaining positions with 0
            arr[i]=0;
        }
    }
    // Optimal
    static void move0sToEnd_2(int[] arr, int n){
        int j=-1;
        //make j point to the first 0
        for(int i=0;i<n;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1) return;//means no 0s present in the array
        for(int i=j+1;i<n;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
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

        arr = new int[]{1,0,2,3,2,0,0,4,5,1};
        n=arr.length;
        move0sToEnd_1(arr,n);
        System.out.println(Arrays.toString(arr));

        arr = new int[]{1,0,2,3,2,0,0,4,5,1};
        n=arr.length;
        move0sToEnd_2(arr,n);
        System.out.println(Arrays.toString(arr));
    }
}
