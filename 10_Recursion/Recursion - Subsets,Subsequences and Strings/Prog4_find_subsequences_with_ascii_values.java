import java.util.ArrayList;
public class Prog4_find_subsequences_with_ascii_values{
    public static void main(String[] args) {
           subseqAscii("", "abc");
        // System.out.println(subseqAsciiRet("", "abc"));
    }
    // p: processed string, up:unprocessed string
    //Either include the character, or exclude the character, or include the ascii value of the character
    static void subseqAscii(String p, String up) {
       if(up.isEmpty()){
        if(p.isEmpty()){
            System.out.println("null");
            return;
        }
            System.out.println(p);
            return;
       }
       char ch=up.charAt(0);

       subseqAscii(p+ch, up.substring(1));
       subseqAscii(p, up.substring(1));
       subseqAscii(p+(int)ch, up.substring(1));
    }

    static ArrayList<String> subseqAsciiRet(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subseqAsciiRet(p+ch, up.substring(1));
        ArrayList<String> second = subseqAsciiRet(p, up.substring(1));
        ArrayList<String> third = subseqAsciiRet(p+(ch+0), up.substring(1));

        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
