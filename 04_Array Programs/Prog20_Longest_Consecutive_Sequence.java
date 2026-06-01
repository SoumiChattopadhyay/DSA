import java.util.Arrays;
import java.util.HashSet;

public class Prog20_Longest_Consecutive_Sequence {
    static boolean linearSearch(int[] arr, int el){
        int n=arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]==el){
                return true;
            }
        }
        return false;
    }
    // Brute Force approach
    static int funct1(int[] arr){
        int n=arr.length;
        if(n==0) return 0;

        int longest=1;
        for(int i=0;i<n;i++){
            int x = arr[i];
            int cnt=1;
            while(linearSearch(arr,x+1)==true){
                cnt++;
                x+=1;
            }
            longest=Math.max(longest,cnt);
        }

        return longest;
    }

    // Better approach (In LeetCode only this solution didnt give TLE)
    static int funct2(int[] arr){
        int n=arr.length;
        if(n==0) return 0;
        Arrays.sort(arr);
        
        int longest=1;
        int lastSmaller=Integer.MIN_VALUE;
        int cntCurr=0;
        for(int i=0;i<n;i++){
            if(lastSmaller==arr[i]-1){//take arr[i] into the sequence and update the lastSmaller to arr[i]
                cntCurr++;
                lastSmaller=arr[i];
            }
            else if(lastSmaller!=arr[i]){//start a new sequence with arr[i]
                cntCurr=1;
                lastSmaller=arr[i];
            }
            longest=Math.max(longest,cntCurr);
        }
        return longest;
    }

    // Optimal Approach
    static int funct3(int[] arr){
        int n=arr.length;
        if(n==0) return 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i=0;i<n;i++){
            hs.add(arr[i]);//avoids duplicates
        }
        int longest=1;
        for(int i=0;i<n;i++){
            if(!hs.contains(arr[i]-1)){//means arr[i] is a starting el(has no prev el)
                int x=arr[i];
                int cntCurr=1;
                while(hs.contains(x+1)){// start iterating
                    cntCurr++;
                    x=x+1;
                }
                longest=Math.max(longest,cntCurr);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        // int[] arr = {102,4,100,1,101,3,2,1,1};
        int[] arr = {100,102,100,101,101,4,3,2,3,2,1,1,1,2};
        System.out.println("Length of LCS = "+funct1(arr));
        System.out.println("Length of LCS = "+funct2(arr));
        System.out.println("Length of LCS = "+funct3(arr));
    }
}
