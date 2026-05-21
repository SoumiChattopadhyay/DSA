public class Prog3_Longest_Substring_without_Repeating_Characters{
    static int funct1(String str){
        int n=str.length();
        int maxLen=0;
        for(int i=0;i<n;i++){
            int[] hash = new int[256];
            for(int j=i;j<n;j++){
                if(hash[str.charAt(j)]==1) break;
                int len = j-i+1;//length of substring
                maxLen = Math.max(maxLen,len);
                hash[str.charAt(j)]=1;
            }
        }
        return maxLen;
    }
    public static void main(String[] args) {
        String str = "cadbzabcd";
        System.out.println(funct1(str));
    }
}