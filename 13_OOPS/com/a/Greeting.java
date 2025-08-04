package com.a;
import static com.b.Message.sendMsg;//sendMsg method has to be public to be imported
public class Greeting {
    public static void main(String[] args) {
        greet();
    }
    public static void greet(){
        System.out.println("Hello yall!");
        sendMsg();
    }
}
