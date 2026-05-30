
public class Prog12_Minimum_Window_Substring {
    // Brute 
    static String funct1(String s, String t){
        int n = s.length();
        int m = t.length();
        int startIdx=-1, minLen=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int cnt=0;
            int[] hash = new int[256];
            for(int j=0;j<m;j++){
                hash[t.charAt(j)]++;
            }
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)]>0) cnt+=1;
                hash[s.charAt(j)]--;
                if(cnt==m){
                    if((j-i+1)<minLen){
                        minLen = j-i+1;
                        startIdx = i;
                    }
                    break;
                }
            }
        }
        if(startIdx==-1) return "";
        return s.substring(startIdx, startIdx+minLen);
    }
    // Optimal
    static String funct2(String s, String t){
        int n = s.length();
        int m = t.length();
        int l=0,r=0,cnt=0,startIdx=-1, minLen=Integer.MAX_VALUE;
        int[] hash = new int[256];
        for(int i=0;i<m;i++) hash[t.charAt(i)]++;
        while(r<n){
            if(hash[s.charAt(r)]>0) cnt+=1;
            hash[s.charAt(r)]--;
            while(cnt==m){
                if(r-l+1<minLen){
                    minLen=r-l+1;
                    startIdx=l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)]>0) cnt-=1;
                l++;
            }
            r++;
        }
        if(startIdx==-1) return "";
        return s.substring(startIdx, startIdx+minLen);
    }
    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";
        System.out.println(funct1(s, t));
        System.out.println(funct2(s, t));

        s = "ddaaabbca";
        t = "abbc";
        System.out.println(funct1(s, t));
        System.out.println(funct2(s, t));
    }
}
