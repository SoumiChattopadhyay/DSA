import java.util.Scanner;
public class Prog63_TCS_NQT_1 {
    // Function to sort the array
    static void quickSort(int arr[], int low, int high) {

        // If there is more than one element
        if (low < high) {

            // Get the correct position of pivot
            int pivot = partition(arr, low, high);

            // Sort left part
            quickSort(arr, low, pivot - 1);

            // Sort right part
            quickSort(arr, pivot + 1, high);
        }
    }

    // Function to place pivot at correct position
    static int partition(int arr[], int low, int high) {

        // Take last element as pivot
        int pivot = arr[high];

        // Index of smaller element
        int i = low - 1;

        // Compare every element with pivot
        for (int j = low; j < high; j++) {

            // If current element is smaller than pivot
            if (arr[j] < pivot) {

                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in its correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
    static int solve(){
       try(Scanner sc = new Scanner(System.in)){
        int n = sc.nextInt();
        if(n<=0){
            return -1;
        }
        int[] dist = new int[n];
        for(int i=0;i<n;i++){
            dist[i] = sc.nextInt();
            if(dist[i]<0){
                return -1;
            }
        }
        quickSort(dist, 0, n-1);
        if(n%2!=0)
            return dist[n/2];//since n is already integer we don't need (int) casts
        else
            return dist[(n/2)-1];
        }//try block not needed it's just used to remove sc.close warning
    }
    public static void main(String[] args) {
        int ans = solve();
        if(ans==-1)
            System.out.println("Invalid Input");
        else
            System.out.println(ans);
    }
}
