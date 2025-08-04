import java.util.Arrays;
public class Prog1_bubble_sort {
    public static void bubbleSort(int[]ar){
        int i,j,n=ar.length;
        for(i=0;i<=n-2;i++){//outer loop runs n-1 times i.e. from 0 to n-2 
            boolean swapped=false;
            for(j=0;j<=n-2-i;j++){//inner loop runs from 1 to n-2-i
                if(ar[j]>ar[j+1]){
                    int temp=ar[j];
                    ar[j]=ar[j+1];
                    ar[j+1]=temp;
                    swapped=true;
                }
            }
            //if for any trace of the array there is no swap,el[j] not > el[j+1] then it means elements are sorted
            if(!swapped){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] ar={5,4,1,3,2};
        bubbleSort(ar);
        Arrays.toString(ar);
    }
}
//i is 0 to <n-1 or n-2
//j is 0 to <n-1-i or n-2-i