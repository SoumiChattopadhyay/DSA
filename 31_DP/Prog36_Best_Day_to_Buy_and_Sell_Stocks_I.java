public class Prog36_Best_Day_to_Buy_and_Sell_Stocks_I {
    static int findMaxProfit(int[] arr,int n){
        int mini=arr[0],profit=0,cost;
        for(int i=1;i<n;i++){
            cost=arr[i]-mini;//mini here is the minimal price at the left of price arr[i]
            profit=Math.max(profit,cost);
            mini=Math.min(mini,arr[i]);//updating mini for next iteration
        }
        return profit;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int n=6;
        System.out.println(findMaxProfit(arr, n));
    }
}
