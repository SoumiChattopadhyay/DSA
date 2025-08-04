import java.util.Arrays;
public class Prog3_insertion_sort {
    public static void insertionSort(int[] arr) {
        int n=arr.length;
        for (int i=1; i<=n-1; i++) { // Start from the second element (index 1)
            int curr=arr[i]; // current element 
            int p=i-1;//previous ele pos
            while (p>=0 && arr[p]>curr) {// this loop only executes if the prev ele is greater than the current ele. Then we shift the prev ele to the right to make space for inserting the curr ele in its correct position.If the first previous element is not greater than the current element the other previous elements are not even checked. This is so because all eles before curr ele form the sorted part.
                arr[p+1]=arr[p];
                p--;
            }
            // This statement always executes. Inserting the curr at its correct position
            arr[p+1]=curr;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 5, 1};
        System.out.println("Original Array: " + Arrays.toString(arr));

        insertionSort(arr);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
