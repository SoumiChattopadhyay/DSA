public class Main {
    public static void main(String[] args) {
        //can access Human class cause both files are in same folder
        System.out.println(Human.population);//static variables can be used even before any object is created unlike other non-static instance variables,they can be only used once object is created
        Human kunal = new Human(22, "Kunal", 10000, false);
        Human rahul = new Human(34, "Rahul", 15000, true);
        Human.message();//only classes can be accessed b/w the files so access message method which is also static via classname
        System.out.println(kunal.age);
        System.out.println(rahul.age);
        // System.out.println(h1.age);//only classes can be accessed so h1 object is created in diff file so it cant be accessed
        fun();//static method
        // you cannot access non static stuff without referencing their instances in a static method
        Main obj = new Main();
        obj.fun2();//non-static method needs referencing
    }
    static void fun(){
        Main obj=new Main();
        obj.greet();
        System.out.println("Fun method");
    }
    void fun2(){
        greet();//non-static method can have non-static stuffs without referencing
        System.out.println("Fun2 method");
    }
    void greet(){
        // non-static methods can have static stuffs coz static stuff is common to all objects has so accessible in non-static method of any object
        // but non-static stuff is exclusive to a specific object so in static method without referencing it is impossible to know which object's non-static stuff is needed
        fun();
        System.out.println("Hello");
    }
}
