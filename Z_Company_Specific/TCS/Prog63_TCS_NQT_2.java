/*

*/
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class TollBooth{
    private Stack<Integer> stack = new Stack<>();

    public void enter(int id){
        stack.push(id);
    }

    public void exit(){
        if(stack.size()==-1)
            return;
        stack.pop();
    }

    public int peek(){
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int count(){
        return stack.size();
    }
}
public class Prog63_TCS_NQT_2 {
    public static void main(String[] args) {
        TollBooth t = new TollBooth();
        Scanner sc = new Scanner(System.in);
        String inpStr = sc.nextLine();
        sc.close();
        String[] inpArr = inpStr.split(",");
        int n = inpArr.length;
        StringBuilder ans = new StringBuilder();
        System.out.println(inpStr);
        System.out.println(Arrays.toString(inpArr));
        int i=0;
        while(i<n){
            String cmd=inpArr[i].trim();
            if(cmd.contains("ENTER")){
                // t.enter(Integer.parseInt(cmd.substring(6)));
                String[] parts = cmd.trim().split(" ");
                t.enter(Integer.parseInt(parts[1]));
            }
            else if(cmd.contains("EXIT")){
                t.exit();
            }
            else if(cmd.contains("PEEK")){
                int a = t.peek();
                if(i!=n-1) ans.append(a+",");
                else ans.append(a);
            }
            else if(cmd.contains("COUNT")){
                int b = t.count();
                if(i!=n-1) ans.append(b+",");
                else ans.append(b);
            }
            i++;
        }
        System.out.println(ans);
    }
}