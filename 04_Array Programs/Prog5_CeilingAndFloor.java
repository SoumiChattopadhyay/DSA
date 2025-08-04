public class Prog5_CeilingAndFloor {
     // return the index: greatest number in array less than or equal to target
   public static int findCeiling(int nums[],int target){
    int left=0,right=nums.length-1;
    // but what if the target is greater than the greatest number in the array
        if(target>nums[right]){
            return -1;
        }
        while(left<=right){
          int mid=left+(right-left)/2;
          if(target==nums[mid]){
            return mid;
          }
          else if(target<nums[mid]){
            right=mid-1;
          }
          else{
            left=mid+1;
          }
        }
        return left;
}
   public static int findFloor(int nums[],int target){
    int left=0,right=nums.length-1;
     // but what if the target is lesser than the least number in the array
     if(target<nums[left]){
        return -1;
    }
           while(left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                return mid;
            }
            else if(target<nums[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
           }
           return right;
   }
    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 9, 14, 16, 18};
        // int[] arr = {2, 3, 5, 9, 14, 15, 16, 18};
        int target = 15;
        System.out.println(findCeiling(arr, target));
        System.out.println(findFloor(arr, target));
    }

}