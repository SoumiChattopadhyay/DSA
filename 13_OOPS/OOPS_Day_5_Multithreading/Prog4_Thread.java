class MyThread1 implements Runnable{
    @Override
    public void run(){
        int i=0;
        while(i<40){
            System.out.println("I am Thread ");
            i++;
        }
    }
}
public class Prog4_Thread {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        Thread th1 = new Thread(t1,"Harry");//passing Runnable object, name
        th1.start();
    }
}
