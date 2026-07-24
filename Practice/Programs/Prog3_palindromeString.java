  //Approach 2 : TC=O(n) SC=O(n)
  public class Prog3_palindromeString {
        public boolean isPalindrome(String s) {
            s=s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
            int start=0,end=s.length()-1;
            while(start<=end){
                if(s.charAt(start)!=s.charAt(end)){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
        public static void main(String[] args) {
            Prog3_palindromeString obj = new Prog3_palindromeString();
            System.out.println(obj.isPalindrome("Mam,="));
        }
    }

    //Approach 2 : TC=O(n) SC=O(1)
    class Solution {
        public boolean isPalindrome(String s) {
            int start=0,end=s.length()-1;
            while(start<end){
                while(start<end && !Character.isLetterOrDigit(s.charAt(start))){
                    start++;
                }
                while(start<end && !Character.isLetterOrDigit(s.charAt(end))){
                    end--;
                }
                if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
    