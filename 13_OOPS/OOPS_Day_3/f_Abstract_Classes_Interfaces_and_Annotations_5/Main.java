public class Main {
    public static void main(String[] args) {
        Daughter d1 = new Daughter(21);
        d1.career();
        d1.bff();
        System.out.println(d1.gpa);

        Son s1 = new Son(18);
        s1.career();
        s1.bff();
        System.out.println(s1.gpa);

        Parent.hello();
        s1.normal();
        d1.normal();

        // We cant create objects of Parent class but we can create Parent class type reference variables pointing to child class objects
        Parent p1 = new Son(20);
        p1.career();
        p1.bff();
        p1.normal();
        System.out.println(p1.age);
        // System.out.println(p1.gpa);//wrong 
        // p1.gpaPrint();//wrong
                
        // Java's Run-time polymorphism 
        // which variables and methods can be accessed depends on the type of the reference variable
        // and which method would run depends on the type of the actual object and is decided during run-time 

    }
}
