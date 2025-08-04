public class Prog1_merge_sort{
    public static void printArray(int ar[]){
        int i;
        for(i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void mergeSort(int arr[],int si, int ei){//divide the array into subarrays until 1 element is left, then return pass the subarray of length 2 to merge function. So merge is technically receiving a single array only but it is dividing it into 2 parts and placing the smaller el. from either part in the temp array  first like this it is sorting that array as a whole
        if(si>=ei){
            return;
        }
        int mid = si+(ei-si)/2;            
        mergeSort(arr, si, mid);//left part
        mergeSort(arr, mid+1, ei);//right part
        merge(arr,si,mid,ei);
        }
    public static void merge(int ar[],int si,int mid,int ei){
        int i=si,j=mid+1,k=0;
        int temp[]=new int[ei-si+1];
        while (i<=mid && j<=ei) {
            if(ar[i]<ar[j]){
                temp[k]=ar[i];
                i++;
            }
            else{
                temp[k]=ar[j];
                j++;
            }
            k++;
        }
        //remaining els of left part
        while(i<=mid){
            temp[k++]=ar[i++];
        }
        //remaining els of right part
        while(j<=ei){
            temp[k++]=ar[j++];
        }
        //copying els into original array
        for(k=0,i=si;k<temp.length;k++,i++){
            ar[i]=temp[k];
        }
    }
    public static void main(String[] args) {
        int ar[] = {6,3,9,2,5,8};
        mergeSort(ar,0,ar.length-1);
        printArray(ar);
    }
}
//single ele in array is always sorted
//mergesort() finds the middle ele & with the help of that middle ele it partitions the array into left & right subarray in the recursive function calls
// becoz of the recursive call the middle ele of the subarrays are found and and like this when the left subarray is a single ele then the recursive call for the right part started and then when we got the single ele