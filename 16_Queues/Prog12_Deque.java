//Deque is an interface. Deqeue type refernce variable and Linked List class type object.
//Queue extends collection interface and Dequeue extends Queue interface 
//Collection interface can be implemented by linked list class so all of these can be implemented by linked list class

import java.util.LinkedList;
import java.util.Deque;

public class Prog12_Deque {
    public static void main(String[] args) {
    Deque<Integer> dq = new LinkedList<>();
    dq.addFirst(1);
    dq.addFirst(2);
    dq.addLast(3);
    dq.addLast(4);
    System.out.println(dq);
    dq.removeFirst();
    dq.removeLast();
    System.out.println(dq.getFirst());
    System.out.println(dq.getLast());
    }
}
