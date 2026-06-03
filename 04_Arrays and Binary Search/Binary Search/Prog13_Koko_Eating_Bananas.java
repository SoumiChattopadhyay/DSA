public class Prog13_Koko_Eating_Bananas {
    static long findTotalTime(int[] piles, int k){
        int n=piles.length;
        long totalTime=0;
        for(int i=0;i<n;i++){
            totalTime+=(int)Math.ceil((double)piles[i]/k);//although += automatically converts to (int) only = doesnt so if this were an assignment statement type casting to int would have been compulsory but here it is optional as we have += not =
        }
        return totalTime;
    }
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
        return ans;
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
