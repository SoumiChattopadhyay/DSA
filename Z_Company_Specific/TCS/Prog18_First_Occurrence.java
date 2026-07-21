public class Prog18_First_Occurrence {
    static int firstSearch(int[] arr, int k) {
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(k<=arr[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        if (low < arr.length && arr[low] == k)
            return low;
        return -1;
    }
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5};
        int k=4;
        System.out.println(firstSearch(arr,k));
    }
}
