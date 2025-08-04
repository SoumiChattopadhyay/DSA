import java.util.Stack;
public class Prog5_queueWithTwoStacks {
    static class Queue{
        static Stack<Integer> s1 = new Stack<>();//.push(el),.pop(),.peek(),.isEmpty()
        static Stack<Integer> s2 = new Stack<>();
        public static boolean isEmpty(){
            return s1.isEmpty();
        }
        public static void add(int data){//TC=O(n)
            while(!s1.isEmpty()){//If S1 is not empty then we push the elements from S1 to S2
                s2.push(s1.pop());
            }
            s1.push(data);// We push the data in S1
            while(!s2.isEmpty()){// Until S2 is empty we push the elements from S2 to S1
                s1.push(s2.pop());
            }
        }//Now S1 looks like a queue which will follow FIFO
        public static int remove(){//TC=O(1)
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }
        public static int peek(){//TC=O(1)
            if(s1.isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
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
