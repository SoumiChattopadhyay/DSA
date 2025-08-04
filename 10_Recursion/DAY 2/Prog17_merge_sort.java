import java.util.Arrays;
public class Prog17_merge_sort {
    public static void main(String[] args) {
        int ar[]={4,2,5,3,1};
        mergeSort(ar,0,ar.length-1);
        System.out.println(Arrays.toString(ar));
   }
   //TC=O(nlogn). O(logn)for diving array into halves and O(n) for merging(copying n)
   public static void mergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;//first we Divide the array into two halves using its mid position
            mergeSort(arr, low, mid);// Next we recursively call the function for both the halves - the left half and the right half
            mergeSort(arr, mid+1, high);//until each half has a single element. low must not be equal to high coz it means both halves have the same element then we would be sending the same element to merge with itself
            merge(arr,low,mid,high); // Then we keep merging the left half and the right half in a sorted manner by calling the merge function
        }
   }
   public static void merge(int[]arr,int low,int mid,int high){
        int temp[]=new int[high-low+1];
        int i=low,j=mid+1,k=0;// i pointer points to starting of left half and j pointer points to starting of right half
        while(i<=mid && j<=high){//copying the elements from both the halves into an array whose size is equal to the the size of left half + right half
            if(arr[i]>arr[j]){
                temp[k]=arr[j];
                j++;
            }else{
                temp[k]=arr[i];
                i++;
            }
            k++;
        }
        while(i<=mid){//copying the remaining els in left half if right half is finished early
            temp[k]=arr[i];
            i++;
            k++;
        }
        while(j<=high){//copying the remaining els in right half if left half is finished early
            temp[k]=arr[j];
            j++;
            k++;
        }
        // for(i=low,k=0;k<temp.length;i++,k++){
        //     arr[i]=temp[k];
        // }
        // for(i=low,k=0;k<temp.length && i<=high;i++,k++){
        //     arr[i]=temp[k];
        // }
        for(k=0;k<temp.length;k++){
            arr[low+k]=temp[k];
        }
   }
}
