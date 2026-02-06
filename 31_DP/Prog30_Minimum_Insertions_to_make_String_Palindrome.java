public class Prog30_Minimum_Insertions_to_make_String_Palindrome {
    // Space Optimization
    // Returns length of LCS of two strings
    static int funct4(int N, int M, String str1, String str2){
        int[] prevRow = new int[M+1];
        int[] currRow = new int[M+1];
        // Base cases
        // idx 0 in dp array represents idx -1 in strings
        for(int ind2=0;ind2<=M;ind2++) prevRow[ind2]=0;//only needed if you initialize dp array with -1. if you initialize it with 0 then not needed
        
        for(int ind1=1;ind1<=N;ind1++){
            currRow = new int[M+1];
            prevRow[0]=currRow[0]=0;//only needed if you initialize dp array with -1. if you initialize it with 0 then not needed
            for(int ind2=1;ind2<=M;ind2++){
                if(str1.charAt(ind1-1)==str2.charAt(ind2-1)){//Your DP table is 1-indexed, but Java strings are 0-indexed.
                    currRow[ind2] = 1 + prevRow[ind2-1];
                }else{
                    currRow[ind2] = 0 + Math.max(prevRow[ind2],currRow[ind2-1]);
                }
            }
            prevRow=currRow;
        }
       return prevRow[M];
    }
    static int findMinInsertions(String str){
        String str2 = new StringBuilder(str).reverse().toString();
        int N = str.length();
        int M = str2.length();
        int LPS_len = funct4(N, M, str, str2);
        int minInserts = N - LPS_len;
        return minInserts;
    }
    public static void main(String[] args) {
        String str = "codingninjas";
        System.out.println("Min. insertions to make string palindrome = "+findMinInsertions(str));
    }
}