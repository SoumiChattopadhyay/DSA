public class Prog1_Jump{
    public static boolean canJump(int[] nums) {
        int maxIdx=0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIdx)
                return false;
            maxIdx=Math.max(maxIdx,i+nums[i]);
            if(maxIdx>=nums.length-1)
                break;
        }
        return true;
    }
    public static void main(String[] args) {
        int ar[]={2,3,1,0,4};
        System.out.println(canJump(ar));
    }
}