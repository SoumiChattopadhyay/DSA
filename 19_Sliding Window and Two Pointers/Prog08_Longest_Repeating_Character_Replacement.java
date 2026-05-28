public class Prog08_Longest_Repeating_Character_Replacement {
    // Brute
    static int funct1(String str, int k){
        int n = str.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            int[] hash = new int[26];
            int maxf=0;
            for(int j=i;j<n;j++){
                hash[str.charAt(j)-'A']++;
                maxf = Math.max(maxf,hash[str.charAt(j)-'A']);
                int len = j-i+1;
                int changes = len - maxf;
                if(changes<=k){
                    maxLen = Math.max(maxLen,len);
                }
                else break;
            }
        }
        return maxLen;
    }
    // Better
    // static int funct2(String str, int k){
    //     int n = str.length();
    //     int l=0,r=0,maxLen=0;
    //     while(r<n){
            
    //     }
    // }
    public static void main(String[] args) {
        String str = "AABABBA";
        int k=2;
        System.out.println(funct1(str, k));
    }
}