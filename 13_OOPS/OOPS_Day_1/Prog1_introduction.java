import java.util.Arrays;

public class Prog1_introduction{
    public static void main(String[] args) {
        // store 5 roll nos
        // int[] numbers = new int[5];

        // store 5 names
        // String[] names = new String[5];

        // store data of 5 students: {roll no, name, marks}
        // int[] rno = new int[5];
        // String[] name = new String[5];
        // float[] marks = new float[5];

        //store data of 5 students in a data structure such that each element of that data structure has the full data
        Student[] students = new Student[5];

        System.out.println(Arrays.toString(students));//[null,null,...,null]
        // we created an array of objects an each object being a complex data type has default value null
        
        // Just declaring the ref. var that in the future is gonna store the memory address of object created in heap memory and returned by the new keyword
        // This ref. var is stored in the stack memory and its memory is allocated during compile-time(when the java code is getting converted into byte code)
        Student kunal;//this reference variable is of data type Student and has 3 properties - rno,name,marks
        // The 'new' keyword dynamically allocates(allocates during run-time i.e. when the program is running) memory in the heap for an object and then returns the reference(memory address) which gets stored in the reference variable
        kunal=new Student();//Initialising the ref. var kunal with the newly created object's memory address
        
        // separator('.') is used to connect the ref var. with the instance variable
        System.out.println(kunal.rno);//0 (coz primitives have their default values)
        System.out.println(kunal.name);//null (coz String is a class, name is ref. var of type String and objects being complex data types have default value null) 
        System.out.println(kunal.marks);//90.0 (we assigned 90.0 as the default value)
    
        // These values are exclusive to kunal object
        kunal.rno=13;
        kunal.name="Kunal";
        kunal.marks=10;//u can initialise this float var. with 10(int) or 10.0f(float) but not 10.0(double)!!
        // kunal.salary=9000; Salary property does not exist in the class template so this cant be done in Java as its static type language but it can be done in python.
        System.out.println(kunal.rno);//13
        System.out.println(kunal.name);//Kunal
        System.out.println(kunal.marks);//10.0

        // The key to Java’s safety is that you cannot manipulate references as you can actual pointers.
        // Thus, you cannot cause an object reference to point to an arbitrary memory location or manipulate it like an integer.
        
        // kunal=null;//The reference is now null, which means no object is attached to it.
        // System.out.println(kunal.rno); //NullPointerException

        // Why do objects necessarily need to be created only by dynamic memory allocation?
        // Ans: Objects in Java are necessarily created using dynamic memory allocation (on the heap) 
        // because their lifetime is not limited to a single method. They may need to exist even after 
        // a method ends, such as when they are returned or shared across different parts of the program.
        // The stack is used for short-lived data like primitive variables and references, which are removed 
        // when the method finishes. But objects are stored in the heap so that they can be managed by the garbage collector, 
        // which frees memory when the object is no longer needed. This automatic memory management is an important feature of Java.
// Stack memory is managed at compile time because the size and structure of method calls and local variables 
// are known in advance. Heap memory is managed at runtime because objects are created dynamically, 
// and their size and lifetime can only be determined while the program is running.

        // Constructor defines what happens when object will be created.
        // It can be used to allocate the values immediately at the time of object creation.
        Student kunal2 = new Student();
        kunal2.greeting();

        Student random=new Student(kunal);
        System.out.println(random.name);//Kunal Kushwaha

        Student random2 = new Student();
        System.out.println(random2.name);

        // Both the reference variables one and two are pointing to the same object because the memory address of the object held by one was assigned to two
        // Any change made to the object via one would be reflected in two as well and vice versa
        Student one = new Student();
        Student two = one;
        one.name = "Something something";
        System.out.println(two.name);//Something something
        two.changeName("Hello hello");
        System.out.println(one.name);//Hello hello
    }
    // create a class
    // We created our own data type using a class
    // Class is a named group of properties and functions(methods). It is a template based on which objects are created. The objects have the same properties but with different values. 
    // Class is template for an object and object is an instance of a class
    // Ex in real life: Car blueprint and different cars(Maruti,Audi). These cars have same properties like engine,color,cost,no. of seats,etc. but may be of different values - electric engine,red,4 or petrol engine,blue,2
    // Class is a logical construct (rule)
    // Object is the physical reality(that occupies space in memory)
    // Ex: Human class is the rule God defined and babies are physical relaities God creates based on that rule
    // Class is instantiated means its objects are created
}

class Student{
        // instance variables:each object gets its own copy. These variables define the state of the object. They are declared directly inside the class outside any block, method or constructor.
        int rno;
        String name;
        float marks=90;//we can also give our own default values to instance variables


    // A constructor is a special method which gets executed when an object is created with needs to be initialised with some values.
    // It gets called when object needs to be bind with particular arguments.
    // Constructor's name is same as the class name.
    // Constructors have no return type not even void
        
        // By default constructor(Takes no arguments) - JAVA's own constructor
        // If there is no other constructor inside the class then the by default constructor gets called which we dont need to create but its present

        // But if another constructor is present then the by default constructor would never be called
        
        // Creating a constructor(Parameterized constructor)
        // If you're keeping the argument names same as the instance variable names then this keyword is compulsory
        Student(int rno,String name,float marks){
            // 'this' keyword is used to access the reference variable when constructor is getting called. this gets replaced by ref.var name
            this.rno=rno;
            this.name=name;
            this.marks=marks;
        }
        // Otherwise argument names must be different
        // Student(int roll,String naam,float m){
        //     rno=roll;
        //     name=naam;
        //     marks=m;
        // }

        // Creating empty constructor 
        // Student(){

        // }

        // Creating another constructor
        // Student(){
        //     this.rno=13;
        //     this.name="Kunal Kushwaha";
        //     this.marks=98.0f;
        // }

        // Creating another constructor
        Student  (Student other) {// So this gets replaced by random and other gets replaced by kunal
        this.name = other.name;
        this.rno = other.rno;
        this.marks = other.marks;
        }

        Student() {
            // this is how you call a constructor from another constructor
            // internally: new Student (13, "default person", 100.0f);
            this (13, "default person", 100.0f);
        }
        void greeting(){
            System.out.println("Hello my name is "+this.name);
            System.out.println("Hello my name is "+name);
        }
        void changeName(String name){
            this.name=name;
        }
}