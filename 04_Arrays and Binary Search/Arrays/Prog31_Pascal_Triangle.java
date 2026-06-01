import java.util.ArrayList;
import java.util.List;

public class Prog31_Pascal_Triangle {
    // Calculates nCr using shortcut approach
    static int nCr(int n, int r){
        long res=1;
        for(int i=0;i<r;i++){
            res=res*(n-i);
            res=res/(i+1);
        }
        return (int)res;
    }
    
    // Prob 1: Given R, C it returns el at (R,C) in Pascal Triangle
    // Optimal Shortcut Approach
    static int funct1(int R, int C){
        return nCr(R-1, C-1);
    }

    // Prob 2: Print any Nth row of Pascal triangle
    // Brute Approach
    static List<Integer> funct2_1(int N){
        List<Integer> ans = new ArrayList<>();
        for(int c=1;c<=N;c++){
            ans.add(nCr(N-1, c-1));
        }
        return ans;
    }
    // Optimal Approach
    static List<Integer> funct2_2(int N){
        List<Integer> ansList = new ArrayList<>();
        int ans=1;
        ansList.add(ans);
        for(int i=1;i<N;i++){//col follows 0-based idxing here, 1st el is printed earlier
            ans=ans*(N-i);
            ans=ans/i;
            ansList.add(ans);
        }
        return ansList;
    }

    // Prob 3: Return the entire Pascal triangle till Nth row in list of lists
    // Brute Approach
    static List<List<Integer>> funct3_1(int N){
        List<List<Integer>> ans = new ArrayList<>();
        for(int row=1;row<=N;row++){
            List<Integer> temp = new ArrayList<>();
            for(int col=1;col<=row;col++){
                temp.add(nCr(row-1,col-1));
            }
            ans.add(temp);
        }
        return ans;
    }
    // Optimal approach
    // static List<List<Integer>> funct3_2(int N){
    //     List<List<Integer>> ans = new ArrayList<>();
    //     for(int i=1;i<=N;i++){
    //         List<Integer> temp = new ArrayList<>();
    //         int res=1;
    //         temp.add(res);
    //         for(int j=1;j<i;j++){//col follows 0-based idxing here, 1st el is printed earlier
    //             res=res*(i-j);
    //             res=res/j;
    //             temp.add(res);
    //         }
    //         ans.add(temp);            
    //     }
    //     return ans;
    // }
    static List<List<Integer>> funct3_2(int N){
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1;i<=N;i++){
            ans.add(funct2_2(i));//replace funct2_2 with a better function name like generateRow           
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int R=5, C=3;
        System.out.println(funct1(R, C));

        int N=6;
        System.out.println(funct2_1(N));
        System.out.println(funct2_2(N));

        System.out.println(funct3_1(N));
        System.out.println(funct3_2(N));

    }
}
