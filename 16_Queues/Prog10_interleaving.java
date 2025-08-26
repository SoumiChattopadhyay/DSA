//Interleave two halves of a queue of even length. TC=O(n), SC=O(n)
import java.util.*;
public class Prog10_interleaving{
    public static void Interleave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();// compulsory if we write q.size() directly in loop after every iteration we get different value
        for(int i=0; i<size/2;i++){
            firstHalf.add(q.remove());
        }
        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        Interleave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
    }
}
