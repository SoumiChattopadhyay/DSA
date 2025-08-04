public class Sn_Main {
    public static void main(String[] args) {
        Singleton_Class obj1 = Singleton_Class.getInstance();
        Singleton_Class obj2 = Singleton_Class.getInstance();
        Singleton_Class obj3 = Singleton_Class.getInstance();
        // all 3 ref variables are pointing to the same object
        System.out.println(obj1+"\n"+obj2+"\n"+obj3);
    }
}
