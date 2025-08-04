package com.b;

// import static com.b.Message.sendMsg;
// if u dont write this statement u must use classname to access the method like below
// if u write this statement u can write sendMsg() instead of Message.sendMsg()

public class Greeting {
    public static void main(String[] args) {
        greet();
    }
    public static void greet(){
        System.out.println("Hello Everyone!");
        Message.sendMsg();
    }
}
