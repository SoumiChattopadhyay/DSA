public class Singleton_Class {
    // Singleton class is a class which is allowed to create only one object
    // Logically if we want to create just one object then we should not allow calling of the constructor.
    // Because whenever the constructor is called, a new object will be created.
    // So made constructor private
    private Singleton_Class(){
        // We can only call the constructor within this class, so we can create objects here but not in a separate file

    }
    //this is a static variable which is a ref. var of Singleton_Class just declared.
    private static Singleton_Class instance;
    //static method of Singleton_Class which returns an object of Singleton_Class type
    public static Singleton_Class getInstance(){
        if(instance==null){
            instance=new Singleton_Class();//calling the constructor and creating object
        }
        return instance;//so if instance points to null then an obj is created and returned and if instance already points to an object then that is only returned
    }
}
