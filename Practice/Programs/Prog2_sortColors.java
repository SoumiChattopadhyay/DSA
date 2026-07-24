public class Prog2_sortColors {
    public void sortColors(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int mid=0;
        while(mid<=high){
            if(nums[mid]==0){
                //swap. Move 0 to left side by swapping mid ele with low ele
                int temp=nums[low];
                nums[low]=nums[mid];
                nums[mid]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else if(nums[mid]==2){
                //swap. Move 2 to right side by swapping mid ele with high ele
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
    public static void main(String[] args) {
        Prog2_sortColors obj = new Prog2_sortColors();
        obj.sortColors(new int[]{2,0,2,1,1,0});
    }
}
