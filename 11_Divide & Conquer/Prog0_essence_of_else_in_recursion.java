public class Prog0_essence_of_else_in_recursion {
    public static String fun(int a){
        if(a==1) {
            return "You are so funny";
        }
        if(a<1){
            a++;
            return fun(a);
        }
        if(a>1){
            a--;
            return fun(a);
        }
        else return "";
    }
    public static void main(String[] args) {
        int a=1;
        String f = fun(a);
        System.out.println(f);
    }
}
// Even though the logic guarantees that one of the if conditions will always execute, the compiler doesn't analyze this deeply enough, so the fallback return is needed to avoid a compile-time error.
//This shows the essence of else in recursion  while returning something, it prevents compile time error