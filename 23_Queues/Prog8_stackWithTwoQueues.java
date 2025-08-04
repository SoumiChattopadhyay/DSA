import java.util.LinkedList;
import java.util.Queue;

public class Prog8_stackWithTwoQueues {
     static class Stack{
        Queue<Integer> q1 = new LinkedList<>(); 
        Queue<Integer> q2 = new LinkedList<>(); //.add(),.remove(),.peek(),.isEmpty()
        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        public void push(int data){//TC=O(n)
            if(!q1.isEmpty()){
                q2.add(data);
                while(!q1.isEmpty()){
                    q2.add(q1.remove());
                }
            }else{
                q1.add(data);
                while(!q2.isEmpty()){
                    q1.add(q2.remove());
                }
            }
            
           
        }
        public int pop(){//TC=O(1)
           
            
        }
        public int peek(){//TC=O(1)
            
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        }
}
}