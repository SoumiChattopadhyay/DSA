public class Prog2_Wrapper_Classes{
    public static void main(String[] args) {
        //  Wrapper classes allow using primitives as objects
        // Advantage: Many properties and functions could be alloted to the objects then
        int a=10,b=20;
        swap(a,b);
        System.out.println(a+" "+b);//won't be swapped as JAVA follows 'pass by value' for primitives
        
        // Integer c=new Integer(10);//another way of writing
        Integer c=10;
        Integer d=20;
        swap(c,d);//still won't be swapped as Integer Class is defined with final keyword(You can check it by Ctrl+CLICK on Integer)

        // What is final keyword?
        // It makes sure you can't modify the variable
        final int BONUS = 20;
        // variables declared with final have to be initialised
        // final guarantees immutability for values(values can't be changed) only if variables are of primitive data type
        // But final only guarantees immutability for references not for values if variables are of reference type
        final Student kunal = new Student();
        kunal.name="Rahul";//allowed
        Student other_object = new Student();
        // kunal=other_object;//not allowed
        other_object=kunal;//allowed
        // kunal=new Student();//not allowed

        // Garbage Collector
        // In Java there is automatic garbage collection. We cant destroy the objects manually, it is done by Java but we can tell Java what actions we want to happen when object is destroyed.
        Student v = new Student();//first object's ref id assigned to ref. var
        v = new Student();//second object's ref id assigned to ref. var obj. So the first object now has no ref. variable pointing to it
    // So the first object must be removed from the memory as it has no reference variable pointing to it which means the finalize method would be called by Java and our message would be printed 
    // but on running this program we see that none of this happens because the the dereferenced object wasn't deleted as there was not much load on the memory

    // So creating load on the memory so that JAVA is bound to delete all the thousands of dereferenced objects
    for(int i=0;i<1000000;i++){
        v = new Student();
    }
    System.out.println(v);
    System.out.println(other_object);
    System.out.println(BONUS);
    }
    static void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
    static void swap(Integer c, Integer d){
        Integer temp=c;
        c=d;
        d=temp;
}
}   
class Student{
    // Instance variable
    String name;
    // Constructor
    Student(){
        this.name="Kunal";
    }
    // So when any object of class Student is dereferenced then this finalize() method will be called and it would destroy the object And print this message we wanted it to print
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object is destroyed.");
    }
}