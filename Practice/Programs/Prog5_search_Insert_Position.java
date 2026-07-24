public class Prog5_search_Insert_Position {
        public int searchInsert(int[] nums, int target) {
            int left=0,right=nums.length-1;
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
    public static void main(String[] args) {
        Prog5_search_Insert_Position obj = new Prog5_search_Insert_Position();
        System.out.println(obj.searchInsert(new int[]{1,3,5,7},2));
    }
}
