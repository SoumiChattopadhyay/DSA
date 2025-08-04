public class Prog19 {
    public static String substring(String str,int si, int ei){
        String substr="";
        for(int i=si;i<ei;i++){
            substr+=str.charAt(i);
        }
        return substr;
    }
    public static void main(String[] args) {
        String str="Hello World";
        System.out.println(substring(str,2,6));
        System.out.println(str.substring(2,5));//in-built function
    }
}
