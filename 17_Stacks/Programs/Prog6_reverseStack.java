import java.util.Stack;
public class Prog6_reverseStack {
    public static void reverseStack(Stack<Integer> s){//Pass by Reference
        if(s.isEmpty()){
            return;
        }
        int top=s.peek();
        s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
     public static void pushAtBottom(Stack<Integer> s,int data){//static method belongs to class Prog4_PushAtBottom
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top=s.peek();
        s.pop();
        pushAtBottom(s,data);
        s.push(top);
    }
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
      public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();//s is a reference variable that holds the reference (memory address) of a Stack<Integer> object.
        s.push(1);
        s.push(2);
        s.push(3);
        // printStack(s); if you write this el.s will be popped so nothing to reverse   
        reverseStack(s);
        printStack(s);
}
}