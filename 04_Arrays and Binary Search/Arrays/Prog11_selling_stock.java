//Time complexity would be proportional to length of prices array i.e. O(n)
public class Prog11_selling_stock {
    public static int buyandSellStocks(int prices[]){
        if (prices == null || prices.length < 2) {
            throw new IllegalArgumentException("At least two stock prices are required.");
        }

        int buyPrice=Integer.MAX_VALUE,maxProfit=0;

        for(int i=0;i<prices.length;i++){
            if(buyPrice<prices[i]){//we will get profit
               int profit=prices[i]-buyPrice;//today's profit
               maxProfit=Math.max(profit,maxProfit);
            }else{
                buyPrice=prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        int stockPrice[]={7,1,5,3,6,4};
        System.out.println("Maximum profit = "+buyandSellStocks(stockPrice));
    }
}
