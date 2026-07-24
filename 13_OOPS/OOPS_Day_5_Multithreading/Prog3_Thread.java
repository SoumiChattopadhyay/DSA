class MyThread1 extends Thread{
    public MyThread1(String name){
        super(name);
    }
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
public class Prog3_Thread {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1("Harry");
        // t1.start();
        System.out.println("Thread name is : "+t1.getName());
        // System.out.println("Thread name is : "+t1.getId());//deprecated
    }
}
