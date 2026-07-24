public class Prog6_evenDigitandmaxWealth {
    public int findNumbers(int[] nums) {
        int i=0,count=0;
        while(i<nums.length){
            if(nums[i]<0)
                nums[i]*=-1;
            if(((int)(Math.log10(nums[i]))+1)%2==0)
                count++;
            i++;
        }
        return count;
    }
    public int maximumWealth(int[][] accounts) {
        int max=Integer.MIN_VALUE;
        for(int i=0;i<accounts.length;i++){
            int wealth=0;
            for(int j=0;j<accounts[i].length;j++){
                wealth += accounts[i][j];
            }
                max=Math.max(max,wealth);
        }
        return max;
    }
    public static void main(String[] args) {
        Prog6_evenDigitandmaxWealth obj = new Prog6_evenDigitandmaxWealth();
        System.out.println(obj.findNumbers(new int[]{12,345,2,6,7896,-5678}));
    }
}
