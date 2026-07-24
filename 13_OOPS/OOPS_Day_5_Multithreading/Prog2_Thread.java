class MyThreadRunnable1 implements Runnable{
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
class MyThreadRunnable2 implements Runnable{
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
public class Prog2_Thread {
    public static void main(String[] args) {
        MyThreadRunnable1 bullet1 = new MyThreadRunnable1();
        Thread gun1 = new Thread(bullet1);

        MyThreadRunnable2 bullet2 = new MyThreadRunnable2();
        Thread gun2 = new Thread(bullet2);

        gun1.start();
        gun2.start();
    }
}
//When MyThread class extends Thread class it gets start() method
//But when MyThread class implements Runnable interface it doesn't get start() method,
//So object of MyThread class is passed to Thread class constructor and then thread object of Thread class is created which can run the start() method