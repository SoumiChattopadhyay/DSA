// Problem Statement: You are the owner of a Shipment company. You use conveyor belts 
// to ship packages from one port to another. The packages must be shipped within 
// 'd' days. The weights of the packages are given in an array 'of weights'. 
// The packages are loaded on the conveyor belts every day in the same order as they 
// appear in the array. The loaded weights must not exceed the maximum weight capacity
// of the ship. Find out the least-weight capacity so that you can ship all the 
// packages within 'd' days .
/*
Input: N = 5, weights = [5, 4, 5, 2, 3, 4, 5, 6], d = 5
Output: 9
Explanation: With a capacity of 9, the packages can be shipped in 5 days as [5,4], [5,2], [3,4], [5] and [6].

Input: N = 3, weights = [1, 2, 3, 4, 5], d = 2
Output: 9
Explanation: With a capacity of 9, the packages can be shipped in 2 days as [1,2,3,4] and [5].
*/
public class Prog17_Capacity_to_Ship_Packages_within_D_Days {
    // Brute
    static int find_Min_Ship_Capacity(int[] arr, int d){
        int maxWt = arr[0], sum=0;
        for(int wt : arr){
            maxWt = Math.max(wt, maxWt);
            sum += wt;
        }
        int ans=Integer.MAX_VALUE; 
        for(int capacity=maxWt;capacity<=sum;capacity++){
            if(findDays(arr,capacity,d)<=d){
                return capacity;
            }
        }
        return ans;
    }
    // Optimal
    static int find_Min_Ship_Capacity_2(int[] arr, int d){
        int maxWt = arr[0], sum=0;
        for(int wt : arr){
            maxWt = Math.max(wt, maxWt);
            sum += wt;
        }
        int low=maxWt, high=sum;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(findDays(arr,mid,d)<=d){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
    static int findDays(int[] arr, int capacity, int d){
        int n=arr.length;
        int load=0,days=1;//load is total shipped weight on a particular day, cnt is to count if all weights are covered or not
        for(int i=0;i<n;i++){
            if(load+arr[i]<=capacity){
                load+=arr[i];
            }
            else{
                days++;
                load=arr[i];
            }
        }
        return days;
    }
    public static void main(String[] args) {
        int[] arr = {5,4,5,2,3,4,5,6};
        int d=5;
        System.out.println(find_Min_Ship_Capacity(arr, d));
        System.out.println(find_Min_Ship_Capacity_2(arr, d));
    }
}
