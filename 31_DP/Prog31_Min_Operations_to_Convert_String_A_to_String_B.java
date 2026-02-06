public class Prog31_Min_Operations_to_Convert_String_A_to_String_B {
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
    static int findMinOps(String str1, String str2){
        int N = str1.length();
        int M = str2.length();
        int minOps = N + M - 2 * funct4(N, M, str1, str2);
        return minOps;
    }
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("Min. no. of operations to convert string 1 to string 2 = "+findMinOps(str1, str2));
    }
}
