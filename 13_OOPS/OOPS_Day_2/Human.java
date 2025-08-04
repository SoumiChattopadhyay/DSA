public class Human {//public class must have its own file with filename same as classname
    // Instance variables
    int age;
    String name;
    int salary;
    boolean married;
    static long population;//Instance variable which is static variable

    public static void message() {
        System.out.println("Hello world");
        //System.out.println(age);//can't use non-static instance variables in static methods without specifying object ref.
        //System.out.println(this.age);//can't use non-static instance variables in static methods without specifying object ref. 
        Human h1 = new Human(13,"Rina",0,false);
        System.out.println(h1.age);
        System.out.println(population);
        System.out.println(Human.population);
    }

    //Constructor that initializes objects with given values
    public Human(int age, String name, int salary, boolean married) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.married = married;
        Human.population += 1;
    }
    
}
