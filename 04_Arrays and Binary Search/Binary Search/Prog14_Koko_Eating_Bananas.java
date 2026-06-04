/*
Koko Eating Bananas
Problem Statement: A monkey Koko is given ‘n’ piles of bananas, whereas the 'ith' pile has 
‘a[i]’ bananas. An integer ‘h’ is also given, which denotes the time (in hours) for all the 
bananas to be eaten. Each hour, the monkey chooses a non-empty pile of bananas and eats ‘k’ 
bananas. If the pile contains less than ‘k’ bananas, then the monkey consumes all the bananas 
and won’t eat any more bananas in that hour.Find the minimum number of bananas ‘k’ to eat 
per hour so that the monkey can eat all the bananas within ‘h’ hours.
Input: N = 4, a[] = {7, 15, 6, 3}, h = 8
Output: 5
Explanation:  If Koko eats 5 bananas/hr, he will take 2, 3, 2, and 1 hour to eat the piles accordingly. So, he will take 8 hours to complete all the piles.  
Input: N = 5, a[] = {25, 12, 8, 14, 19}, h = 5
Output: 25
Explanation: If Koko eats 25 bananas/hr, he will take 1, 1, 1, 1, and 1 hour to eat the piles accordingly.
*/
public class Prog14_Koko_Eating_Bananas {
    // Brute
    static int funct1(int[] piles, int h){
        int n = piles.length;
        int maxPile = 0;
        for(int i=0;i<n;i++){
            maxPile = Math.max(maxPile,piles[i]);
        }
        for(int k=1;k<=maxPile;k++){
            long totalTime = findTotalTime(piles,k);
            if(totalTime<=h){
                return k;
            }
        }
        return -1;
    }
    // Optimal
    static int funct2(int[] piles, int h){
        int n = piles.length;
        int maxPile = 0;
        for(int i=0;i<n;i++){
            maxPile = Math.max(maxPile,piles[i]);
        }
        int low=1,high=maxPile;
        int ans=-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            long totalTime = findTotalTime(piles,mid);
            if(totalTime<=h){
                ans = mid;//possible answer
                high=mid-1;//try smaller k
            }
            else{//if totalTime>h
                low=mid+1;//try higher k
            }
        }
        return ans;//or return low
    }
    static long findTotalTime(int[] piles, int k){
        int n=piles.length;
        long totalTime=0;
        for(int i=0;i<n;i++){
            totalTime+=(int)Math.ceil((double)piles[i]/(double)k);//although += automatically converts to (int) only = doesnt so if this were an assignment statement type casting to int would have been compulsory but here it is optional as we have += not =
        }
        return totalTime;
    } 
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(funct1(piles, h));
        System.out.println(funct2(piles, h));

        piles = new int[]{10,20,30};
        h = 2;
        System.out.println(funct1(piles, h));
        System.out.println(funct2(piles, h));
    }
}
