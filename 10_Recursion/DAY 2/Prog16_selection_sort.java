import java.util.Arrays;

public class Prog16_selection_sort {
    public static void main(String[] args) {
        int ar[]={2,1,4,5,3};
        selectionSort(ar,ar.length-1,0,0);
        System.out.println(Arrays.toString(ar));
    }
    // row=turn no. or no. of swaps happening in that turn --> 4 3 2 1 0
    // col=pos of el.
    public static void selectionSort(int ar[],int row,int col,int maxPos){
        if(row==0){
            return;
        }
        if(col<=row){//each turn happening
            if(ar[col]>ar[maxPos]){
                maxPos=col;
            }
            selectionSort(ar, row, col+1, maxPos);
        }
        else{//when col>=row
            int temp=ar[row];
            ar[row]=ar[maxPos];
            ar[maxPos]=temp;
            selectionSort(ar, row-1, 0, 0);
        }
    }
}