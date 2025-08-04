public class ObjectPrint {
    // Instance variable
    int num;
    //Constructor
    public ObjectPrint(int num){
        this.num=num;
    }
    @Override
    public String toString(){
        return "ObjectPrint{"+"num="+num+"}";
    }
    public static void main(String[] args) {
        ObjectPrint obj = new ObjectPrint(43);

        //println() method of PrintStream class calls valueOf() method of String class to get the String value of the object which calls toString() method of the class the object belongs to which is Object class
        //Every class extends the Object class,for Arrays toString() method exists but since there is no toString() method defined for this object's class ObjectPrint Class so the default method is used which is the toString() method of the highest class
        // System.out.println(obj);//ObjectPrint@2c7b84de
        
        //So if we create our own toString() method then the default toString() method of Object class will be overridden
        //At run-time it is determined that this method would be executed
        System.out.println(obj);//ObjectPrint{num=43}

        //final keyword is used to create constants,but it is also used to prevent overriding
        //A method that is final cannot be overridden
        //Methods declared final somehow provide performance announcement, compiler is free to inline the calls to them Cause the compiler will know that these methods will not be overridden and I know overriding all these things happens at runtime ok so when a small final method is know when a method is called Java compiler can copy the byte code ok from the subroutine or whatever like Internet implementation is directly with a compile code of the calling method hence eliminating the overhead associated with this method called which one to actually resolve it no this will be only resolved because it cannot be overwritten what is remaining there this will be resolved so that the extra step is gone 
    
    //the actual version of the method to run is only known at runtime.That’s called dynamic method dispatch or runtime polymorphism. Because of this, there’s a small runtime overhead — the JVM has to figure out which version of the method to call.
    //But if a method is final, it cannot be overridden by any subclass.That means: The compiler and JVM already know exactly which method will run — there is no need to wait until runtime.
    //Since the method is final:
    // The JVM/compiler can inline the method — it means: Instead of making a separate method call,the compiler can copy the actual code of the method directly into the caller method.
    // This saves time — there’s no jump to another method, and no need to resolve at runtime.
    // Ex:
//     final int square(int x){
//         return x*x;
//     }
//     int result = square(5);
//Instead of calling square() at runtime, the compiler may convert this to:
//     int result = 5 * 5;
    }
}