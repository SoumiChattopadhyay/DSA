package Diff_package;//open it's parent directory

public class ObjectDemo {//ObjectDemo class extends Object class like any other class as Object class is the root class, so if it has its own instance methods similar to Object class then its methods will override the Object class's methods(Late Binding - which method will run is decided by the JVM during run-time)
   int num;//Instance variable
   //parameterized constructor
   public ObjectDemo(int num){
    // super();//default constructor of superclass(Object class) gets automatically called even if we don't write this
        this.num=num;
   }
   //default constructor self-created
   public ObjectDemo(){
    // super();//default constructor of superclass(Object class) gets automatically called even if we don't write this
        this.num=-1;
   }
   //Instance methods
//    @Override
//    protected void finalize() throws Throwable {
//        super.finalize();
//    }
   @Override
   public String toString() {
       return super.toString();
   }
   @Override
   public int hashCode() {
       return super.hashCode();
   }
   @Override
   public boolean equals(Object obj) {
    //    return super.equals(obj);
          return this.num==((ObjectDemo)obj).num;//for obj1.equals(obj3) this means obj1 and obj3 which is getting referenced via Object type ref var becoz thats what needs to be in the argument or else no overriding so that obj3 now needs to be casted into ObjectDemo type because Object superclass has no idea about ObjectDemo subclass and its exclusive instance variables. So we cast and use the var.
   }
   @Override
   protected Object clone() throws CloneNotSupportedException {
       return super.clone();
   }
   public static void main(String[] args) {
        ObjectDemo obj1 = new ObjectDemo(34);
        System.out.println(obj1.hashCode());

        ObjectDemo obj2 = obj1;
        System.out.println(obj2.hashCode());

        System.out.println(obj1.equals(obj2));//true

        ObjectDemo obj3 = new ObjectDemo(34);
        System.out.println(obj3.hashCode());

        // == is a comparator. It checks if the 2 ref. variables are pointing to the same object or not
        if(obj1==obj3){
            System.out.println("obj1 is equal to obj3");
        }
        //.equals() is a method. This also checks if the 2 ref. variables are pointing to the same object or not but Java's String class overrides the .equals() method from the Object class and checks if just the content of the 2 objects is same or not.
        //We can make our ObjectDemo class do this overriding like the String class
        if(obj1.equals(obj3)){
            System.out.println("obj1 is equal to obj3");//so this is printed
        }

        // getClass()method of Object class
        System.out.println(obj1.getClass());//class Diff_package.ObjectDemo
        // This method can be used to get some data about the class the instance belongs to. For example:
        System.out.println(obj1.getClass().getMethods());
        System.out.println(obj1.getClass().getName());//Diff_package.ObjectDemo
        // getClass() method is final so we cant override it
        // When we get this getClass information, it will be stored in the heap area and whatever object we get from this - obj1.getClass() is gonna be a class object, we can get data about the class with it
   }
}
