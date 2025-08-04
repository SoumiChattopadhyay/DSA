import java.util.Arrays;

public class Prog15_bubble_sort_recursion {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 2, 5, 1 };
        bubbleSort(arr, arr.length-1, 0);
        System.out.println(Arrays.toString(arr));
    }
    //row means step no., col means pos of each el. 
    public static void bubbleSort(int[] ar, int row, int col) {
        if(row==0){
            return;
        }
        if(col<row){
            if (ar[col] > ar[col+1]) {
                int temp = ar[col];
                ar[col] = ar[col+1];
                ar[col+1] = temp;
            }
            bubbleSort(ar, row, col+1);
        }
        else{//Once col > row, it means one full pass is done, and it recurses to the next pass with row-1.
            bubbleSort(ar, row-1, 0);
        }
    }
}   
// 
// step no.(row)     
//      4           
//      3
//      2
//      1
//      0