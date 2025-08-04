public class Prog6_PalindromeString {
    public static void main(String[] args) {
        String str = "abcdcba";
        if (str == null || str.length() == 0) {
            System.out.println("Palindrome");
        }
        str = str.toLowerCase();

        //Method 1 - Better
        int start=0,end=str.length()-1,k=0;
        while(start<=end){
            if(str.charAt(start)==str.charAt(end)){
                start++;
                end--;
            }else{
                k++;
                break;
            }
        }
        if(k==0)
        System.out.println("Palindrome");
        else
        System.out.println("Not Palindrome");


        //Method 3
        boolean g=true;
        for(int i=0;i<=str.length()/2;i++){
            char s = str.charAt(i);
            char e = str.charAt(str.length()-1-i);
            if(s!=e){
                g=false;
                System.out.println("Not Palindrome");
                break;
            }
        }
        if(g)//if(g==true)
        System.out.println("Palindrome");

        
        //Method 2
        StringBuilder b = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--){//Bro please give i-- not i++
            b.append(str.charAt(i));
        }
        if(str.equals(b.toString())){
            System.out.println("Palindrome String");
        }else{
            System.out.println("Not Palindrome");
        }

    }
}
//str == b.toString() compares memory references, not actual string content.
// Even if both strings contain the same characters, they are stored in different memory locations.
// So, == will return false, even for a palindrome.