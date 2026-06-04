import java.util.Arrays;

public class Prog19_Aggressive_Cows {
    // Brute
    // Function to find maximum possible minimum distance between cows
    static int findDist(int[] stalls, int cows){
        int n=stalls.length;
        Arrays.sort(stalls);
        int maxDist = stalls[n-1] - stalls[0];//get the maximum possible distance
        int ans=0;
        for(int d=1;d<maxDist;d++){//try all possible distances
            if(canPlace(stalls, d, cows)){//if cows can be placed with distance d
                ans=d;//update ans
            }
        }
        return ans;//return the maximum valid distance
    }
    // Function to check if cows can be placed with min distance d
    static boolean canPlace(int[] stalls, int d, int cows){
        int lastPos = stalls[0];//place the first cow at the first stall
        int count=1;
        for(int i=1;i<stalls.length;i++){
            if(stalls[i]-lastPos>=d){//if current stall is atleast 'd' distance away from last cow
                count++;// place the cow in the stall
                lastPos=stalls[i];
            }
            if(count==cows){//all cows placed
                return true;
            }
        }
        return false;
    }

    // Optimal
    // Function to find the maximum possible minimum distance between cows
    static int findDist2(int[] stalls, int cows){
        Arrays.sort(stalls);
        int n = stalls.length;
        int maxDist = stalls[n-1]-stalls[0];
        int low=stalls[0], high=maxDist, ans=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canPlace(stalls, mid, cows)){
                ans = mid;
                low = mid+1;//see if they can be placed at a longer dist
            }
            else{
                high = mid-1;//if cant place cows at a min distance of mid, reduce the distance
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] stalls = {0,3,4,7,10,9};//denotes position of stalls
        int cows=4;//no. of cows
        System.out.println(findDist(stalls, cows));
        System.out.println(findDist2(stalls, cows));
    }
}
