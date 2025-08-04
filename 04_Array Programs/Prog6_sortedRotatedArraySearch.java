//find pivot
//binary search left half of pivot
//binary search right half of pivot
public class Prog6_sortedRotatedArraySearch {
    public static void main(String[] args) {
        // int ar[]={5,1,3};//first time
        int ar[] = {4,5,6,7,0,1,2};//sorted and rotated array around 2. Pivot taken here is the Peak Before the Drop (Largest Element)i.e. 7
        // int ar[] = {4,5,6,7,8,0,1,2};//first time -> mid el.=7. if(start el.<mid el.)means we are in the left half of the array. pivot must be right to it =>start=mid+1
        // int ar[] = {7,8,0,1,2,3,4};//first time -> mid el.=1. if(start el.>mid el.)=>means we are in the right half of the array. pivot must be left to it =>end=mid-1
        //7,0 is the ony descending part
        int target=1;
        System.out.println(target+" is located in position "+sortedRotatedArraySearch(ar, target));
    }
    public static int sortedRotatedArraySearch(int[] ar, int target){
        int pivot = findPivot(ar,target);
        int firstTry=binarySearch(ar, 0, pivot, target);
        if(firstTry!=-1){
            return firstTry;
        }
        return binarySearch(ar, pivot+1, ar.length-1, target);
    }
    public static int findPivot(int[]ar,int target){
        int start=0,end=ar.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && ar[mid]>ar[mid+1]){//If mid is the last element (mid == end), then ar[mid + 1] does not exist, leading to an out-of-bounds error.So, we ensure mid < end before accessing ar[mid + 1].
                return mid;
            }
            if(mid>start && ar[mid]<ar[mid-1]){//If mid == start (i.e., the first element), then ar[mid - 1] does not exist, leading to an out-of-bounds error.So, we ensure mid > start before accessing ar[mid - 1].
                return mid-1;
            }
            if(ar[mid]<=ar[start]){//means we are in the right half of the array. pivot must be left to it
                end=mid-1;
            }else{//if ar[mid]>ar[start] //means we are in the left half of the array. pivot must be right to it
                start=mid+1;
            }
        }
        return -1;
    }
// Why Not Compare with ar[end]?
// If we use ar[mid] compared to ar[end], we lose a clear direction because:
// ar[end] belongs to the right sorted half, and it's always smaller than the pivot.
// If ar[mid] > ar[end], it only tells us that mid is in the left sorted half but doesn’t directly indicate where the pivot is.
// If ar[mid] < ar[end], it means mid is in the rotated half, but we already infer this from checking ar[mid] with ar[start].
    public static int binarySearch(int ar[], int start, int end, int key) {

        while (start <= end) {

            int mid = start + (end-start) / 2;
            if (key == ar[mid])
                return mid; // Found key
            else if (key < ar[mid])
                end = mid - 1;
            else
                start = mid + 1;
            }
        return -1; // Key not found
    }
}
