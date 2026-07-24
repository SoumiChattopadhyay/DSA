class MyThread1 extends Thread{
    @Override
    public void run(){
        int i=0;
        while(i<40){
            System.out.println("Thread 1 Cooking food");
            System.out.println("I am happy");
            i++;
        }
    }
}
class MyThread2 extends Thread{
    @Override
    public void run(){
        int i=0;
        while(i<40){
            System.out.println("Thread 2 Chatting with her");
            System.out.println("I am sad");
            i++;
        }
    }
}
public class Prog1_Thread{
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        MyThread2 t2 = new MyThread2();
        t1.start();
        t2.start();
    }
}