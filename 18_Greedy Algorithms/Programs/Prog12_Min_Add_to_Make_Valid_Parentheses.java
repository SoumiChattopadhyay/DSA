public class Prog12_Min_Add_to_Make_Valid_Parentheses {
    static int minAdd(String str){
        int open=0;
        int add=0;

        for(char ch : str.toCharArray()){
            if(ch=='('){
                open++;
            }
            else{
                if(open>0){
                    open--;
                }
                else{
                    add++;
                }
            }
        }
        
        return add+open;
    }
    public static void main(String[] args) {
        String str = "()))((";
        System.out.println(minAdd(str));
    }
}
