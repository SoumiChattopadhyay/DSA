import java.util.Arrays;

public class Prog2_static_classes{
    // Outer Classes can never be static but their inner class can be static
    // static inner class - not dependent on object of outer class, is common to all objs.
    static class Test1{
        String name;//instance var. 
        Test1(String name){//constructor
            this.name=name;
        }
    }
    // non-static inner class - dependent on object of outer class
    class Test2{
        String name;//instance var.
        Test2(String name){//constructor
            this.name=name;
        }
        @Override
        public String toString(){
            return this.name;
        }
    }
    public static void main(String[] args) {
        Test1 obj1 = new Test1("Kunal");
        System.out.println(obj1.name);

        Test1 obj2 = new Test1("Rahul");
        System.out.println(obj2.name);

        Prog2_static_classes p = new Prog2_static_classes();
        Test2 t2 = p.new Test2("Reena");
        System.out.println(t2.name);

       
        System.out.println(Test3.name);//System is a class and in its file PrintStream class or file is imported,then in the System class out is the static ref. variable of PrintStream class created and it points to null which means default console,println() is instance method inside PrintStream class which out ref. var can execute using dot operator
    // separator '.' binds the instance variables and instance methods to the ref. variables if they are non-static and to the className if they are static
// println() method calls the valueOf() method which returns "null" if the variable is null or it calls the toString() method which returns the string value of the variable and returns that
Arrays.toString(new int[]{1,2,3,4});//Arrays is a class which has static method named toString() which accepts array as argument and returns a String in a very nice way by adding brackets and commas 
System.out.println(Arrays.toString(new int[]{1,2,3,4}));//println() then prints the string toString() returns
System.out.println(t2);//Prog2_static_classes$Test2@4617c264
//here println(obj) method calls the valueOf(obj) method which in turn prepares to call toString(obj) method but it sees that there the object obj
// has no toString() method like the array object had so Java uses its default toString() method which prints className+@+hashvalue
// Java hierarchially first checks in the object(for non-static methods) then in the class(for static methods) and if nothing found then uses the default method
// So if we make our own toString method then Java will execute that only and print what we specify
}
}
class Test3{
    static String name="Mina";
}

// static class B{  <---- Wrong, outer classes can't be static
// }