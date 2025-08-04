import java.util.*;
public class Prog4_PushAtBottom {//TC=O(n). No extra space is used - adv. of recursion
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
      public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();//s is a reference variable that holds the reference (memory address) of a Stack<Integer> object.
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s,4);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
    }
}
//Impicit stack is created and each recursive call gets its stack frame and so the data which is popped from the explicit stack created by us is not completely lost and can be pushed later.
