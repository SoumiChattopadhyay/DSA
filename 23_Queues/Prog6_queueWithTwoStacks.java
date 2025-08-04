//performing O(n) operations for Pop and O(1) for Push
import java.util.Stack;
public class Prog6_queueWithTwoStacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();//.push(el),.pop(),.peek(),.isEmpty()
        static Stack<Integer> s2 = new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){//TC=O(1)
            s1.push(data);
        }//Now S1 looks like a queue which will follow FIFO
        public static int remove(){//TC=O(n)
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int del = s2.pop();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return del;
        }
        public static int peek(){//TC=O(n)
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int val=s2.peek();
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return val;
        }
    }
    public static void main(String[] args) {
        Queue.add(1);
        Queue.add(2);
        Queue.add(3);
        while(!Queue.s1.isEmpty()){
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
