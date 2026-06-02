public class Prog13_Koko_Eating_Bananas {
    static int funct(int[] piles, int k){
        int n=piles.length;
        int totalTime=0;
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
            int totalTime = funct(piles,k);
            if(totalTime<=h){
                return k;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;
        System.out.println(funct1(piles, h));
    }
}
