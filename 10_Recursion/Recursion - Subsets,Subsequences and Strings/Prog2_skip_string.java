public class Prog2_skip_string {
    public static void main(String[] args) {
        System.out.println(skipString("bacapplecdahappledah","apple",""));
        System.out.println(skipString2("bacapplcdahappledah","apple"));
        System.out.println(skipAppNotApple("bccbapplebccbapp"));
    }
    
    // Skips every occurrence of string del from string str
    static String skipString(String str,String del,String ans){
        if(str.isEmpty()){
            return ans;
        }
        char ch=str.charAt(0);
        if(str.startsWith(del)){
            ans = skipString(str.substring(del.length()), del, ans);
        }else{
            ans = skipString(str.substring(1), del, ans+ch);
        }
        return ans;
    }
    
   
    static String skipString2(String str,String del){
        if(str.isEmpty()){
            return "";
        }
        char ch=str.charAt(0);
        if(str.startsWith(del)){
            return skipString2(str.substring(del.length()), del);
        }else{
            return ch+skipString2(str.substring(1), del);
        }
    }
    static String skipAppNotApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(3));
        } else {
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }
}
