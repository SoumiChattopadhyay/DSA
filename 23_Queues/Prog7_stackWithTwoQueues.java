import java.util.*;
public class Prog7_stackWithTwoQueues {
    static class Stack{
        Queue<Integer> q1 = new LinkedList<>(); 
        Queue<Integer> q2 = new LinkedList<>(); //.add(),.remove(),.peek(),.isEmpty(), .size()
        public boolean isEmpty(){
            return q1.isEmpty() && q2.isEmpty();
        }
        public void push(int data){
            if(!q1.isEmpty()){
                q1.add(data);
            }else{
                q2.add(data);
            }
        }
        public int pop(){//TC=O(n)
            int top=-1;
            if(isEmpty()){//this isEmpty is function of the stack which you made
                System.out.println("Stack is empty");
                return -1;
            }
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){// this isEmpty is the function of Queue in JCF
                    top=q1.remove();
                    if(q1.isEmpty()){
                        break;
                    }
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){// this isEmpty is the function of Queue in JCF
                    top=q2.remove();
                    if(q2.isEmpty()){
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }
        public int peek(){//TC=O(n)
            int top=-1;
            if(isEmpty()){
                System.out.println("Stack is empty");
                return -1;
            }
            if(!q1.isEmpty()){
                while(!q1.isEmpty()){
                    top=q1.remove();
                    q2.add(top);
                }
            }else{
                while(!q2.isEmpty()){
                    top=q2.remove();
                    q1.add(top);
                }
            }
            return top;
        }
    }
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        }
}
