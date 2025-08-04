public class Prog2_quick_sort{
    public static void printArray(int ar[]){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void quickSort(int ar[],int low,int high){
        if(low<high){//base condition
            int pidx = partition(ar, low, high); //partition index or pivot
            quickSort(ar, low, pidx-1);//left part
            quickSort(ar, pidx+1, high);//right part
        }
    }
    public static int partition(int ar[],int low,int high){
        int pivot = ar[high];//taking last element as pivot
        int i=low-1;
        for(int j=low;j<high;j++){
            if(ar[j]<=pivot){//elements before pivot must be smaller and after pivot must be greater than it (may not be sorted) then pivot will be at correct position
                i++;//i pointer increased by 1 only when ar[j]<=pivot and then the element there swapped with ar[j]
                //swap
                int temp = ar[j];
                ar[j]=ar[i];
                ar[i]=temp;
            }
        }
        //finally all eles smaller than pivot placed on left of it. placing pivot in its position
        i++;
        int temp = pivot;
        ar[high]=ar[i];//dont write pivot then no change in array
        ar[i]=temp;
        return i;//returning index of pivot(partition index)
    }
    public static void main(String[] args) {
        int ar[]={6,3,9,8,2,5};
        quickSort(ar,0,ar.length-1);
        printArray(ar);
    }
}
//Cannot make a static reference to the non-static method