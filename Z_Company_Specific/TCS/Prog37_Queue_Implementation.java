public class Prog37_Queue_Implementation {
    class Queue {

        int[] arr = new int[1000];
        int front = 0;
        int rear = -1;

        // Enqueue
        void enqueue(int x) {
            if (rear == arr.length - 1) {
                System.out.println("Queue Overflow");
                return;
            }
            arr[++rear] = x;
        }

        // Dequeue
        int dequeue() {
            if (front > rear) {
                System.out.println("Queue Underflow");
                return -1;
            }
            return arr[front++];
        }

        // Front element
        int peek() {
            if (front > rear)
                return -1;

            return arr[front];
        }

        boolean isEmpty() {
            return front > rear;
        }
    }
    public static void main(String[] args) {
        
    }
}