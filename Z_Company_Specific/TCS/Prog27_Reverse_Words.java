/*
Given a string s, reverse the string without reversing its individual words. Words are separated by dots(.).

Note: The string may contain leading or trailing dots(.) or multiple dots(.) between two words. The returned string should only have a single dot(.) separating the words, and no extra dots should be included.

Examples :

Input: s = "i.like.this.program.very.much"
Output: "much.very.program.this.like.i"
Explanation: The words in the input string are reversed while maintaining the dots as separators, resulting in "much.very.program.this.like.i".
*/

import java.util.Arrays;

public class Prog27_Reverse_Words {
    static String reverseWords(String str){
        String[] words = str.split("\\.");
        System.out.println(Arrays.toString(words));
        StringBuilder ans = new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(!words[i].isEmpty()){
                if(ans.length()>0)
                    ans.append(".");
                ans.append(words[i]);
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String str = "i.like.this.program.very.much";////much.very.program.this.like.i
        System.out.println(reverseWords(str)+"\n");

        str = "i.like.this  .program  .very.much";
        System.out.println(reverseWords(str)+"\n");//much.very.program  .this  .like.i

        str = ".i.like.this.program.very.much.";
        System.out.println(reverseWords(str)+"\n");//much.very.program.this.like.i

        // we would've gotten much.very.program.this.like.i. as output which is undesirable if we hadn't written the first if
    }
}
/*
The trick here is:
Split the string using ".".
Ignore empty strings (caused by multiple or leading/trailing dots).
Traverse the words from the end.
Join them with a single dot.

Why split("\\.")?
. is a special regex character (it matches any character).
To split on a literal dot, you must escape it: s.split("\\.")
If you write: s.split(".")
it won't behave as expected because "." in regex means any character
*/