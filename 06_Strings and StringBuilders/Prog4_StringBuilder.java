public class Prog4_StringBuilder {
    //Using StringBuilder
    public static void main(String[] args) {
        StringBuilder b = new StringBuilder();
        char a=97;
        for(int i=0;i<26;i++){//TC=O(n)
            b.append((char)(a+i));
        }
        System.out.println(b);
    }
      //Using String
      public static void Series() {
        String s ="";
        char a=97;
        for(int i=0;i<26;i++){//TC=O(n^2)
            s+=(char)(a+i);
        }
        System.out.println(s);
    }
}
