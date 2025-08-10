package Diff_package;//open it's parent directory
import Encapsulation_in_Detail_3.A;
public class SubClass extends A{
    public SubClass(int num,String name,int[]arr){
        super(num,name,arr);
    }
    public static void main(String[] args) {
        A obj = new A(13,"Ram",new int[3]);
        System.out.println(obj.getNum());//right coz can access public var in subclass in diff package
        // System.out.println(obj.arr);//wrong coz cant access default var in subclass in diff package
        // System.out.println(obj.num);//wrong coz cant access private var in subclass in diff package
        
        // In a different package, protected members of the superclass can only be accessed through subclass object 
        // System.out.println(obj.name);//wrong
        SubClass obj_sc = new SubClass(14, "Shyam", new int[4]);
        System.out.println(obj_sc.name);//right
        // System.out.println(obj_sc.num);//wrong
        // System.out.println(obj_sc.arr);//wrong
        System.out.println(obj_sc.getNum());//right

        // A has no idea about it's subclass, so object of A cannot be used to access protected members in diff package subclass
        // SubClass has no idea of SubClass2.protected member of Superclass cannot be accessed using a subclass object in another subclass
        // SubClass2 objj = new SubClass2(2, "Manu", new int[4]);
        // System.out.println(objj.name);//wrong
    }
}
// Subclass of Subclass of A can also access the protected members
class SubSubClass extends SubClass{
    public SubSubClass(int num,String name,int[]arr){
        super(num, name, arr);
    }
    public static void main(String[] args) {
        SubSubClass ssc1 = new SubSubClass(4, "Gattu", new int[4]);
        System.out.println(ssc1.name);
    }
}

// SubClass has no idea about SubClass2 and SubClass2 has no idea of SubClass
// so we cannot access 
class SubClass2 extends A{
    public SubClass2(int num,String name,int[]arr){
        super(num,name,arr);
    }
    public static void main(String[] args) {
        SubClass2 obj = new SubClass2(7,"Haldiram",new int[7]);
        System.out.println(obj.name);

        //instanceof
        System.out.println(obj instanceof A);//true. (indirectly)
        System.out.println(obj instanceof SubClass2);//true. 
        System.out.println(obj instanceof Object);//true. (every object is instance of object class)
    }
}
// First do "cd.." coz play button will make the file run from Diff_package folder but we want to run this file from it's parent folder
// To Run SubClass(the public class in this file which matches the file name)
// javac Diff_package/SubClass.java
// java Diff_package/SubClass.java
// To run any other non-public class from this file
// javac Diff_package/SubClass.java
// java Diff_package.SubClass2