// The Pivot taken here is the Peak Before the Drop (Largest Element) not the Rotation point
public class Prog6_sortedRotatedDuplicateArraySearch {
    public static void main(String[] args) {
        int ar[] = {2,5,6,0,0,1,2};
        // int ar[] = {0,5,6,0,0,0,0};//mid el.= start el.and mid el.= end el.
        // int ar[] = {6,5,6,6,6,6,6};//mid el.= start el.and mid el.= end el. and el[start]>el[start+1] => return start
        // int ar[] = {6,6,5,6,6,6,6,6};//mid el.= start el.and mid el.= end el. but el[start] not > el[start+1] => start++
        
        // int ar[] = {0,0,0,0,0,5,0};//mid el.= start el.and mid el.= end el. and el[end]<el[end-1] => return end-1
        // int ar[] = {6,6,6,6,6,5,6};//mid el.= start el.and mid el.= end el. but el[end] not <el[end-1]=> end--
       
        // int ar[] = {0,5,6,2,5,6,1};//mid el.!= start el.and mid el.!= end el. and start el.< mid el. => we are in the left half and pivot is right to us.=>start=mid+1
        // int ar[] = {2,5,6,2,5,6,1};//mid el.= start el.and mid el.!= end el. and start el.= mid el. & mid el.>end el. => we are in the left half and pivot is right to us.=>start=mid+1
        // int ar[] = {6,7,1,2,3,4,5};//mid el.!= start el.and mid el.!= end el. and start el.>mid el. =>end=mid-1
        int target=2;
        System.out.println(sortedRotatedArraySearch(ar, target));
    }
    public static boolean sortedRotatedArraySearch(int[] ar, int target){
        int pivot = findPivotwithDuplicates(ar,target);
        boolean firstTry=binarySearch(ar, 0, pivot, target);
        if(firstTry!=false){
            return firstTry;
        }
        return binarySearch(ar, pivot+1, ar.length-1, target);
    }
    public static int findPivotwithDuplicates(int[]ar,int target){
        int start=0,end=ar.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(mid<end && ar[mid]>ar[mid+1]){//If mid is the last element (mid == end), then ar[mid + 1] does not exist, leading to an out-of-bounds error.So, we ensure mid < end before accessing ar[mid + 1].
                return mid;
            }
            if(mid>start && ar[mid]<ar[mid-1]){//If mid == start (i.e., the first element), then ar[mid - 1] does not exist, leading to an out-of-bounds error.So, we ensure mid > start before accessing ar[mid - 1].
                return mid-1;
            }
            if(ar[mid]==ar[start]&&ar[mid]==ar[end]){
                if(start<end && ar[start]>ar[start+1]){
                    return start;
                }
                start++;
                if(end>start && ar[end]<ar[end-1]){
                    return end-1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if((ar[start]<ar[mid]) || (ar[mid]==ar[start]&&ar[mid]>ar[end])){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    public static boolean binarySearch(int ar[], int start, int end, int key) {

        while (start <= end) {

            int mid = start + (end-start) / 2;
            if (key == ar[mid])
                return true; // Found key
            else if (key < ar[mid])
                end = mid - 1;
            else
                start = mid + 1;
            }
        return false; // Key not found
    }
}
//Ignore duplicates