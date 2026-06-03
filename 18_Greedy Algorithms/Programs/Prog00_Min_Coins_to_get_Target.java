import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prog00_Min_Coins_to_get_Target {
    // Greedy (Min coins to get target), TC = O(n * log n)
    static int find_Min_Coins(int[] coins, int amount){
        int n = coins.length;
        Arrays.sort(coins);
        List<Integer> result = new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            while(coins[i]<=amount){
                result.add(coins[i]);
                amount-=coins[i];
            }
        }
        System.out.print("Coins used: "+result+", No. of coins used: ");
        return result.size();
    }
    static int find_Min_Coins2(int[] arr, int target){
        int n = arr.length;
        Arrays.sort(arr);
        int i=n-1,cnt=0,x=target;
        while(x>0){
            if(arr[i]<=x){
                x-=arr[i];
                cnt++;
            }
            if(arr[i]>x){
                i--;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,10,20,50};
        System.out.println(find_Min_Coins(arr, 63));
        System.out.println(find_Min_Coins2(arr, 63));
        System.out.println(find_Min_Coins(arr, 69));
        System.out.println(find_Min_Coins2(arr, 69));
        arr = new int[]{1,3,4};
        System.out.println(find_Min_Coins(arr, 6));//greedy fails ans shud be 2
        System.out.println(find_Min_Coins2(arr, 6));//greedy fails ans shud be 2
    }
}
