import java.util.*;
public class Prog6_IndianCoins {
    public static void main(String[] args) {
        Integer coins[]={1,2,5,10,20,50,100,200,500,2000};//Indian coin system is canonical. Greedy approach can be applied to it
        //Dont take primitive type otherwise reverseorder wont work
        Arrays.sort(coins,Comparator.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();
        int coinCount=0;
        int amount=590;

        for(int i=0;i<coins.length;i++){
            if(coins[i]<=amount){
                while(coins[i]<=amount){
                    ans.add(coins[i]);
                    coinCount++;
                    amount-=coins[i];
                }
            }
        }
        System.out.println("Coin count="+coinCount);
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+",");
        }
    }
}
