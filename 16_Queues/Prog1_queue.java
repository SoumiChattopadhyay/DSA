public class Prog1_queue {  
    static int front = 0;//static variable means all the instances of Prog1_queue class will share the same value of this variable. If it is changed changes reflected in all.  

    static class Queue {  //static class means all the instances of Prog1_queue class will share the same value of this nested class Queue. This nested class of Prog1_queue class is for defining the structure of the queue and it does not have any methods of its own
        int size, rear;  
        int[] arr;  

        public Queue(int n) {  
            this.size = n;  
            this.rear = -1;  
            this.arr = new int[n];  
        }  
    }  
    //These are the methods of Prog1_queue class which are used for defining the functionality of the queue
    public static boolean isEmpty(Queue q) {  //static method means all the instances of Prog1_queue class will share the same value of this method
        return q.rear==-1;  
    }  
    // TC = O(1)  

    public static void add(Queue q, int value) { //static method means all the instances of Prog1_queue class will share the same value of this method 
        if (q.rear == q.size-1) {
            System.out.println("Queue is full");
            return;  
        }  
        q.arr[++q.rear] = value;  
    }  
    // TC = O(1)  

    public static int remove(Queue q) {  //static method means all the instances of Prog1_queue class will share the same value of this method
        if (isEmpty(q)) { 
            System.out.println("Queue is empty"); 
            return -1;  
        }
        int frontEl=q.arr[0];
        for(int i=0;i<q.arr.length;i++){
            q.arr[i]=q.arr[i+1];
        }  
        front=front+1;
        return frontEl;  
    }  
    // TC = O(n)  

    public static int peek(Queue q) { //static method means all the instances of Prog1_queue class will share the same value of this method 
        if (isEmpty(q)) {  
            return -1;  
        }  
        return q.arr[front];  
    }  
    // TC = O(1)  

    public static void main(String[] args) { //main method of Prog1_queue class which is always static
        Queue q = new Queue(3);  //Queue class is inside Prog1_queue class so its object can be creation statement can be written anywhere inside Prog1_queue class even in its main method

        add(q, 10);  
        add(q, 20);  
        add(q, 30);  

        while (!isEmpty(q)) {  
            System.out.println(peek(q)); // Print front element  
            remove(q); // Remove front element  
        }  
    }  
}


// public class Prog1_queue {  
//     static int front = 0;  //static variable means all the instances of Prog1_queue class will share the same value of this variable. If it is changed changes reflected in all.  

//     static class Queue {  //static class means all the instances of Prog1_queue class will share the same value of this nested class Queue. This nested class of Prog1_queue class is for defining the structure of the queue and it does not have any methods of its own
//         static int size, rear;  // Changed to static to share these variables across all instances of Queue
//         static int[] arr;  // Changed to static to share this array across all instances of Queue

//         public static void initializeQueue(int n) {  // Constructor logic moved to static method since these variables are now static so need to create an instance of Queue to access those variables
//             size = n;
//             rear = -1;
//             arr = new int[n];
//         }  
//     }  
//     //These are the methods of Prog1_queue class which are used for defining the functionality of the queue
//     public static boolean isEmpty() {  // No need to pass Queue object
//         return Queue.rear == -1;  
//     }  
//     // TC = O(1)  

//     public static void add(int value) {  // No need to pass Queue object
//         if (Queue.rear == Queue.size - 1) {  
//             return;  
//         }  
//         Queue.arr[++Queue.rear] = value;  
//     }  
//     // TC = O(1)  

//     public static int remove() {  // No need to pass Queue object
//         if (isEmpty()) { 
//             System.out.println("Queue is empty"); 
//             return -1;  
//         }
//         int frontEl = Queue.arr[0];
//         for (int i = 0; i < Queue.arr.length - 1; i++) {  // Fixed to avoid ArrayIndexOutOfBoundsException
//             Queue.arr[i] = Queue.arr[i + 1];
//         }  
//         front = front + 1;
//         return frontEl;  
//     }  
//     // TC = O(n)  

//     public static int peek() {  // No need to pass Queue object
//         if (isEmpty()) {  
//             return -1;  
//         }  
//         return Queue.arr[front];  
//     }  
//     // TC = O(1)  

//     public static void main(String[] args) { //main method of Prog1_queue class which is always static
//         Queue.initializeQueue(3);  // Initialize the queue with size 3

//         add(10);  
//         add(20);  
//         add(30);  

//         while (!isEmpty()) {  
//             System.out.println(peek()); // Print front element  
//             remove(); // Remove front element  
//         }  
//     }  
// }
