public class Prog2_selection_sort {
    public static void selectionSort(int[]ar){
        int i,j,n=ar.length;
        for(i=0;i<n-1;i++){
            int minPos=i;
            for(j=i+1;j<n;j++){
                if(ar[minPos]>ar[j]){
                    minPos=j;
                }
            }
            //swap in outer loop
            int temp = ar[minPos];
            ar[minPos]=ar[i];
            ar[i]=temp;
        }
        for(i=0;i<n;i++){
            System.out.print(ar[i]+"  ");
        }
    }
    public static void main(String[] args) {
        selectionSort(new int[]{5,4,1,3,2});
    }
}
//i is 0 to <n-1 or n-2
//j is i+1 to <n or n-1 