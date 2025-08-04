public class Prog7_String_Compression {
    public static void main(String[] args) {
        //using String
        String str = "aaabbccddeee";
        String newstr="";//A new String object is created in memory everytime we concatenate a string using + operator. So, it is not efficient to use + operator for string concatenation in a loop. Instead, we can use StringBuilder or StringBuffer which are mutable and do not create a new object every time we concatenate a string.
        
        for(int i=0;i<str.length();i++){
            Integer count=1;
            //if the current character is same as the next character, increment the count
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }//we have used the same variable i the while loop so that we can skip the same character in the next iteration of the for loop
            newstr+=str.charAt(i);//add the current character to the new string
            if(count>1){//if the character appears more than once, we need to add the count to the new string
                newstr+=count.toString();
            }
        }
        System.out.println(newstr);//a3b2c2d2e3
        //using StringBuilder
        StringBuilder sb = new StringBuilder();//StringBuilder is mutable, so we can change the value of sb without creating a new object
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        System.out.println(sb.toString());//a4b4c4d4e3
        //using StringBuffer
        StringBuffer sbf = new StringBuffer();//StringBuffer is mutable, so we can change the value of sbf without creating a new object
        for(int i=0;i<str.length();i++){
            Integer count=1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sbf.append(str.charAt(i));
            if(count>1){
                sbf.append(count.toString());
            }
        }
        System.out.println(sbf.toString());//a4b4c4d4e3
    }
}
