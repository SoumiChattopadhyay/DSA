public class Prog07_No_of_Substrings_Containing_All_Three_Characters {
    // Brute
    static int funct1(String str){
        int n=str.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            int[] hash = new int[3];
            for(int j=i;j<n;j++){
                hash[str.charAt(j)-'a'] = 1;
                if(hash[0]+hash[1]+hash[2]==3){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    // Better
    static int funct2(String str){
        int n=str.length();
        int cnt=0;
        for(int i=0;i<n;i++){
            int[] hash = new int[3];
            for(int j=i;j<n;j++){
                hash[str.charAt(j)-'a'] = 1;
                if(hash[0]+hash[1]+hash[2]==3){
                    cnt+=n-j;
                    break;
                }
            }
        }
        return cnt;
    }
    // Optimal
    static int funct3(String str){
        int n=str.length();
        int[] lastSeen = new int[3];
        for(int i=0;i<3;i++) lastSeen[i]=-1;
        int cnt=0;
        for(int i=0;i<n;i++){
            lastSeen[str.charAt(i)-'a'] = i;
            if(lastSeen[0]!=-1 && lastSeen[1]!=-1 && lastSeen[2]!=-1){
                int minLastSeen = Math.min(lastSeen[0],Math.min(lastSeen[1],lastSeen[2]));
                cnt+=minLastSeen+1;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        String s = "bbacba";
        System.out.println(funct1(s));
        System.out.println(funct2(s));
        System.out.println(funct3(s));
    }
}
