public class Prog1_skip_character_approach1 {
    public static void main(String[] args) {
        skip("abaccbanq", 'a', "");
        System.out.println(skip2("abaccbanq", 'a'));
        System.out.println(skip3("abaccbanq", 'a', ""));
    }
// Q. Why ans+ch in skip1,skip3 but ch+skip2.. in skip2?
// In skip1 and skip3 we are having an unprocessed string - ans as a parameter and in every recursive call if the char is allowed it is added to  ans, so if its added before then as we are tracing the string from left to right obviously the ans is getting formed in right to left order so we need to add character after ans i.e. ans+ch not ch+ans
// But in skip2 the first funct has the first ch and all the other characters that come later and are allowed will come with the recursion calls after this first character so definitely the order is maintained
    
    // Skips every occurrence of character del from string str. and does not return anything
    // str is unprocessed string and ans is processed string and in the processed string we must not include del
    static void skip(String str, char del, String ans) {
        if (str.isEmpty()) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        if (ch == del) {
            skip(str.substring(1), del, ans);// substring is creating a new object each time.(Strings are immutable)
        } else {
            skip(str.substring(1), del, ans+ch);
        }
    }

    static String skip2(String str, char del) {
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (ch == del) {
            return skip2(str.substring(1), del);
        } else {
            return ch+skip2(str.substring(1), del);
        }
    }
    
    // Why ans = skip3... not ans += skip3...?
    // Becoz we full ans forms in the end so we need to pass on that full ans to the prev functs without any modification so we use ans= not ans+=
    static String skip3(String str, char del, String ans) {
        if (str.isEmpty()) {
            return ans;
        }
        char ch = str.charAt(0);
        if (ch == del) {
            ans = skip3(str.substring(1), del, ans);
        } else {
            ans = skip3(str.substring(1), del, ans + ch);
        }
        return ans;
    }
}
