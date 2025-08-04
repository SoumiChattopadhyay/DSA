import java.util.*;
//One property of stack is that the order in which elements go in and the order in which elements come out are reverse of each other
public class Prog13_StackwithDeque {
    static class Stack{//Creating a stack class which is implemented using a Deque
        Deque<Integer> dq = new LinkedList<>();
        public void push(int data){//TC=O(1)
            dq.addLast(data);
        }
        public int pop(){//TC=O(1)
            return dq.removeLast();
        }
        public int peek(){//TC=O(1)
            return dq.getLast();
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek = "+s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
