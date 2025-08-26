public class Prog2_circularqueue {  
    static class Queue {  //static class means all the instances of Prog2_circularqueue class will share the same value of this nested class Queue. This nested class of Prog2_circularqueue class is for defining the structure of the queue and it does not have any methods of its own
        int size, rear,front;  
        int[] arr;  

        public Queue(int n) {  
            this.size = n;  
            this.rear = -1;
            this.front=-1;  
            this.arr = new int[n];  
        }  
    }  
    //These are the methods of Prog2_circularqueue class which are used for defining the functionality of the queue
    public static boolean isEmpty(Queue q) {  //static method means all the instances of Prog2_circularqueue class will share the same value of this method
        return q.rear==-1 && q.front==-1;  
    }  
    // TC = O(1)  
    public static boolean isFull(Queue q) {  //static method means all the instances of Prog2_circularqueue class will share the same value of this method
        return (q.rear+1)%q.size==q.front; //(rear+1)%size 
    }  
    // TC = O(1) 
    public static void add(Queue q, int data) { //static method means all the instances of Prog2_circularqueue class will share the same value of this method 
        if (isFull(q)) {
            System.out.println("Queue is full");
            return;  
        }  
        if(q.front==-1){
            q.front=0;
        }
        q.rear=(q.rear+1)%q.size;
        q.arr[q.rear]=data;
    }  
    // TC = O(1)  

    public static int remove(Queue q) {  //static method means all the instances of Prog2_circularqueue class will share the same value of this method
        if (isEmpty(q)) { 
            System.out.println("Queue is empty"); 
            return -1;  
        }
        int result=q.arr[q.front];
        if(q.rear==q.front){
            q.rear=q.front=-1;
        }else{
            q.front=(q.front+1)%q.size;
        }
        return result;  
    }  
    // TC = O(1)  

    public static int peek(Queue q) { //static method means all the instances of Prog2_circularqueue class will share the same value of this method 
        if (isEmpty(q)) {  
            return -1;  
        }  
        return q.arr[q.front];  
    }  
    // TC = O(1)  

    public static void main(String[] args) { //main method of Prog2_circularqueue class which is always static
        Queue q = new Queue(3);  //Queue class is inside Prog2_circularqueue class so its object can be creation statement can be written anywhere inside Prog2_circularqueue class even in its main method

        add(q, 1);  
        add(q, 2);  
        add(q, 3); //1 2 3
        System.out.println(remove(q)); //2 3
        add(q, 4);//2 3 4
        System.out.println(remove(q));//3 4
        add(q, 5);//3 4 5
        while (!isEmpty(q)) {  
            System.out.println(peek(q)); // Print front element  
            remove(q); // Remove front element  
        }
        System.out.println(q.rear+" "+q.front); //-1 -1
    }  
}


