import java.util.Deque;
import java.util.LinkedList;

public class Prog14_QueuewithDeque {
    static class Queue{//Creating a queue class which is implemented using a Deque
        Deque<Integer> dq = new LinkedList<>();
        public void add(int data){//TC=O(1)
            dq.addLast(data);
        }
        public int remove(){//TC=O(1)
            return dq.removeFirst();
        }
        public int peek(){//TC=O(1)
            return dq.getFirst();
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println("peek = "+q.peek());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}
