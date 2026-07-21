//The Ceil of x is the smallest element ≥ x.
public class Prog21_Ceil_in_a_Sorted_Array {
    static int findCeil(int[] arr, int x) {
        int low=0,high=arr.length-1;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]>=x){
                ans=mid;//possible answer
                high=mid-1;// search for a smaller valid ceil
            }
            else{
                low=mid+1;
            }
        }
        return ans;        
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int x=5;
        System.out.println(findCeil(arr, x));
    }
}
