public class Prog3_queueWithLL {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static class Queue{
        public  Node head=null;
        public  Node tail=null;
        public  boolean isEmpty(){
            return head==null && tail==null;
        }
        public  void add(int data){// in queue we add at last //TC=O(1)
            Node newNode = new Node(data);
            if(head==null){
                head=tail=newNode;
                return;
            }
            tail.next=newNode;
            tail=newNode;
        }
        public  int remove(){// in queue we remove from first //TC=O(1)
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int d = head.data;
            if(head==tail){//single element
                head=tail=null;
            }else{
                head=head.next;
            }
            return d;
        }
        public  int peek(){//TC=O(1)
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        System.out.println(q.remove());
        Node ptr=q.head;
        while(ptr!=null){
            System.out.println(ptr.data);
            ptr=ptr.next;
        }
}
}
