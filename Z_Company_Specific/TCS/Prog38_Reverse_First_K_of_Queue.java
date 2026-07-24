import java.util.Stack;
import java.util.Queue;

public class Prog38_Reverse_First_K_of_Queue {
    static Queue<Integer> modifyQueue(Queue<Integer> q, int k) {

        Stack<Integer> st = new Stack<>();

        // Step 1: Push first k els into stack using q.remove() FIFO
        for (int i = 0; i < k; i++) {
            st.push(q.remove());
        }

        // Step 2: Enqueu those k els from Stack to Queue LIFO
        while (!st.isEmpty()) {
            q.add(st.pop());
        }

        // Step 3: Move the remaining (n-k) elements from front to rear
        int rem = q.size() - k;

        for (int i = 0; i < rem; i++) {
            q.add(q.remove());
        }

        return q;
    }
    public static void main(String[] args) {
        
    }
}
