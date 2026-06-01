import java.util.ArrayList;
import java.util.List;

public class Prog22_Find_the_Missing_and_Repeating_Number {
    // Brute Force
    // TC=O(N^2) ,SC=O(1)
    static List<Integer> funct1(int[] arr, int n){
        int repeating=-1,missing=-1;
        for(int i=1;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(i==arr[j]){
                    cnt++;
                }
            }
            if(cnt==2) repeating=i;
            else if(cnt==0) missing=i;
            if(repeating!=-1 && missing!=-1) break;
        }
        List<Integer> ls = new ArrayList<>();
        ls.add(missing);
        ls.add(repeating);

        return ls;
    }
     // Better Approach
    // TC=O(2N) ,SC=O(N)
    static List<Integer> funct2(int[] arr, int n){
        int[] hashArr = new int[n+1];
        for(int i=0;i<n;i++){
            hashArr[arr[i]]++;
        }
        int repeating=-1,missing=-1;
        for(int i=1;i<n;i++){
            if(hashArr[i]==0) missing=i;
            else if(hashArr[i]==2) repeating=i;
            if(repeating!=-1 && missing!=-1) break;
        }
        List<Integer> ls = new ArrayList<>();
        ls.add(missing);
        ls.add(repeating);
        return ls;
    }
    // Optimal Sol
    // Maths Sol
    static List<Integer> funct3(int[] arr){
        long n = arr.length;
        long Sn = ((n)*(n+1))/2;
        long S2n = ((n)*(n+1)*(2*n+1))/6;
        long S=0,S2=0;
        for(int i=0;i<n;i++){
            S+=arr[i];
            S2+=(long)arr[i]*(long)arr[i];
        }
        long xyDiff = S-Sn;
        long xySqDiff = S2-S2n;
        long xySum = xySqDiff/xyDiff;
        long x = (xyDiff+xySum)/2;
        long y = xySum-x;
        
        List<Integer> ls = new ArrayList<>();
        ls.add((int)y);
        ls.add((int)x);
        
        return ls;
    }
    // Optimal sol
    // XOR sol
    static List<Integer> funct4(int[] arr, int n){
        int num=0;
        for(int i=0;i<n;i++){
            num^=arr[i];
            num^=(i+1);
        }
        // try different bitPos until & operation with num yields 1
        int bitPos=0;
        while(true){
            if((num & (1<<bitPos)) != 0) break;//dont do if(num & bitPos != 0) as operator precedence affects it. Java reads it like: if(num & ((1<<bitPos) != 0)) break; Now (1<<bitPos) != 0 becomes a boolean (true or false), and you’re trying to do: num & true which is invalid.
            bitPos++;
        }
        //now we have the correct bitPos
        // so divide no.s into zero-club and one-club based on bit they have at that bitPos
        int one=0,zero=0;
        for(int i=0;i<n;i++){
            // one-th club
            if((arr[i] & (1<<bitPos))!=0) one^=arr[i];
            // zero-th club
            else zero^=arr[i];
        }
        for(int i=1;i<=n;i++){
            // one-th club
            if((i & (1<<bitPos))!=0) one^=i;
            // zero-th club
            else zero^=i;
        }

        // Find which is missing and which is repeating
        int cnt=0,missing,repeating;
        for(int i=0;i<n;i++){
            if(arr[i]==zero) cnt++;
        }
        if(cnt==2){
            repeating=zero;
            missing=one;
        } 
        else{
            missing=zero;
            repeating=one;
        }

        List<Integer> ls = new ArrayList<>();
        ls.add(missing);
        ls.add(repeating);

        return ls;
    }
    public static void main(String[] args) {
        int[] arr = {4,3,6,2,1,1};
        int n=6;
        System.out.println(funct1(arr, n));
        System.out.println(funct2(arr, n));
        System.out.println(funct3(arr));
        System.out.println(funct4(arr,n));
    }
}
