public class Prog6_mountainArray {//Mountain array or Bitonic Array
    public static void main(String[] args) {
        int[] arr = {3,5,2,1};
        System.out.println(findinmountainArray(arr,1));
        System.out.println(peakIndexInMountainArray(arr));
}
    public static int findinmountainArray(int[]arr,int target){//returns the index
        int peak=peakIndexInMountainArray(arr);
        int ans = orderAgnosticbinarySearch(arr,target,0,peak);
        if(ans==-1){
            ans=orderAgnosticbinarySearch(arr,target,peak+1,arr.length-1);
        }
        return ans;
    }
    public static int peakIndexInMountainArray(int[] ar) {
        int start=0,end=ar.length-1;
        while(start<end){// We use < not = becoz when start=end in the end then we will get the largest element
            int mid=start+(end-start)/2;
            if(ar[mid]>ar[mid+1])//we are in descending part of the array and this descending part might or might not contain the peak element
                end=mid;
            else if(ar[mid]<ar[mid+1])//we are in ascending part of array and this ascending part does not contain the peak element
                start=mid+1;
           //in the end, start == end,so loop breaks and start & end point to the largest number because of the 2 checks above
           }
        return start;//or return end  
    }
    public static int orderAgnosticbinarySearch(int ar[], int key, int start, int end) {
        // Check if the array is sorted in ascending or descending order
        boolean isAscending = ar[start] < ar[end];

        while (start <= end) {

            int mid = start + (end - start) / 2;
            if (key == ar[mid])
                return mid; // Found key
            if (isAscending) { // Ascending order logic
                if (key < ar[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } else { // Descending order logic
                if (key > ar[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1; // Key not found
    }
    
}
