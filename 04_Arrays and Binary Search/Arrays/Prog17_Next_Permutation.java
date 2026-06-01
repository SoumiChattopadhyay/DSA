import java.util.Arrays;
public class Prog17_Next_Permutation {
    // Function that finds the next permutation of array
    static void funct(int[] arr){
        int n=arr.length;
        int ind=-1;
        // Figuring out breakpoint
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                ind=i;
                break;
            }
        }
        // Edge Case
        if(ind==-1){//(arr in increasing order from backwards i.e. max permutation already given 
        // so next permutation will be the first one i.e. the smallest one i.e. the reverse of arr)
            System.out.println(Arrays.toString(reverse(0,n-1,arr)));
            return;
        }

        // Find smallest el in right of breakpoint which is greater than el in left of breakpoint and swap them
        for(int i=n-1;i>=ind+1;i--){
            if(arr[i]>arr[ind]){
                // swap
                int temp=arr[i];
                arr[i]=arr[ind];
                arr[ind]=temp;
                // then break
                break;
            }
        }

        // Reverse the remaining els
        System.out.println(Arrays.toString(reverse(ind+1, n-1, arr)));
    }
    // Function to reverse any portion of the array
    static int[] reverse(int start, int end, int[] arr){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,4,3,0,0};
        funct(arr);
    }
}