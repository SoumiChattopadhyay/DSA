public class Prog08_rotationCount {
        public static void main(String[] args) {
            int[] arr = {4,5,6,7,0,1,2};
            System.out.println(countRotations(arr));
        }
    
        private static int countRotations(int[] arr) {
            int pivot = findPivot(arr);//el 7(at idx 3)
            return pivot + 1;//no. of rotations
        }
    
        // use this for non duplicates
        static int findPivot(int[] arr) {
            int start = 0;
            int end = arr.length - 1;
            while (start<=end) {
                int mid = start + (end - start) / 2;
                // 4 cases over here
                // Case 1: If (ele at mid) greater than (ele at mid+1) return mid
                if (mid<end && arr[mid]>arr[mid+1]) {//since we are accessing arr[mid+1] so we must ensure mid is < end
                    return mid;
                }
                // Case 2: If (ele at mid) less than (ele at mid-1) return mid-1
                if (mid>start && arr[mid]<arr[mid-1]) {
                    return mid-1;
                }
                // Case 3: If (ele at mid) less than (ele at start) or (ele at start) is (ele at mid), then we must go further left to find the pivot
                if (arr[mid]<=arr[start]) {//Why is <= used instead of <? Because in a non-duplicate array: arr[mid] == arr[start] can only happen when: mid == start
                    end = mid-1;
                } else {// Case 4: If (ele at mid) greater than (ele at start), then we must go further right to find the pivot
                    start = mid+1;
                }
            }
            return -1;
        }
    
        // use this when arr contains duplicates
        static int findPivotWithDuplicates(int[] arr) {
            int start = 0;
            int end = arr.length - 1;
            while (start <= end) {
                int mid = start+(end-start)/2;
                // 5 cases over here
                // Case 1: If (ele at mid) greater than (ele at mid+1) return mid
                if (mid<end && arr[mid]>arr[mid+1]) {
                    return mid;
                }
                // Case 2: If (ele at mid) less than (ele at mid-1) return mid-1
                if (mid>start && arr[mid]<arr[mid-1]) {
                    return mid-1;
                }
                // Case 3: If elements at middle, start, end are equal then just skip the duplicates
                if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                    // skip the duplicates
                    // NOTE: What if these elements at start and end-1 were the pivot?? Ex:[8,0,2,4,8,8,8] and [8,8,8,8,9,8]
                    // check if start is pivot 
                    if (arr[start] > arr[start+1]) {
                        return start;
                    }
                    start++;//skip duplicates 
                    // check if end-1 is pivot
                    if (arr[end] < arr[end-1]) {
                        return end-1;
                    }
                    end--;//skip duplicates
                }
                // condition to decide which side is definitely sorted, so we can search for the pivot in the other side.
                // If elements at middle, start, end are not equal and if (ele at start) lesser than (ele at mid) or if (ele at end) lesser than (ele at mid)
                // means left side is sorted(strictly increasing), so pivot should be in right
                else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                    start = mid+1;
                } else {//means I cannot conclude that the left side is sorted(strictly increasing) and the pivot is on the right side, so I'll search on the left side.
                    end = mid-1;
                }
            }
            return -1;
        }
}
/*
arr[start] < arr[mid] case:
    [4,5,6,7,0,1,2]
     s   m
So left side of mid is sorted(strictly increasing) so we must search for pivot in the right side of mid

arr[start] == arr[mid] && arr[mid] > arr[end] case:
    [3,3,3,4,5,1,2]
    s   m        e
Since the end value is smaller, rotation must have happened(pivot must be present) somewhere in the right side of mid.
*/