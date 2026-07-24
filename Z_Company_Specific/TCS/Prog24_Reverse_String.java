public class Prog24_Reverse_String {
    static String reverseString(String str){
        int i=0, j=str.length()-1;
        char[] strArr = str.toCharArray(); 
        while(i<j){
            char temp=strArr[i];
            strArr[i]=strArr[j];
            strArr[j]=temp;
            i++;
            j--;
        }
        return new String(strArr);
    }
    public static void main(String[] args) {
        String str="Geeks";
        System.out.println(reverseString(str));
    }
}
