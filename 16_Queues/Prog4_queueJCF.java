//In JCF, Queue is not a class it is an interface and we cannot create objects of interfaces. 
//So we make objects of classes which can implement queue - LinkedList, ArrayDeque
import java.util.*;//All utility packages imported
public class Prog4_queueJCF {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        // Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.remove();
        q.add(4);
        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }

    }
}//TC=O(1) for all 3 operations