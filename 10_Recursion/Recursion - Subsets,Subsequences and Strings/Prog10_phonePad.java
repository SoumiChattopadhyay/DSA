import java.util.ArrayList;
public class Prog10_phonePad {
    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    public static void main(String[] args) {
        phonePad("23","");
        System.out.println(phonePadRet("23", ""));
        System.out.println(phonePadCount("23",""));
    }
    static void phonePad(String up, String p) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int dig = up.charAt(0)-'0';// this will convert '2' into 2
        for(int i=(dig-2)*dig; i<(dig-1)*3; i++){
            char ch = (char)('a'+i);
            phonePad(up.substring(1), p+ch);
        }
    }
    static ArrayList<String> phonePadRet(String up,String p) {
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        int dig = up.charAt(0)-'0';// this will convert '2' into 2
        
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> remList=new ArrayList<>();
        for(int i=(dig-2)*dig; i<(dig-1)*3; i++){
            char ch = (char)('a'+i);
            remList = phonePadRet(up.substring(1), p+ch);
            list.addAll(remList);
        }
        return list;
    }
    static int phonePadCount(String up,String p) {
        if(up.isEmpty()){
            System.out.println(p);
            return 1;
        }
        int count=0;
        int dig = up.charAt(0)-'0';// this will convert '2' into 2
        for(int i=(dig-2)*dig; i<(dig-1)*3; i++){
            char ch = (char)('a'+i);
            count+=phonePadCount(up.substring(1), p+ch);
        }
        return count;
    }
}
