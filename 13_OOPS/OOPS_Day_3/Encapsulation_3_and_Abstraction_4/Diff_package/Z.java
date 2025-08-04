package Diff_package;//open it's parent directory(Encapsulation_3_and_abstraction_4)
import Encapsulation_in_Detail_3.A;
public class Z{
    public static void main(String[] args) {
        A obj = new A(12,"Rahul",new int[12]);
        System.out.println(obj.getNum());//can access coz public funct
        // System.out.println(obj.num);//cant access coz private var cant be accessed from diff package and not subclass(world)
        // System.out.println(obj.name);//cant access coz protected cant be accessed from diff package and not subclass(world)
        // System.out.println(obj.arr);//cant access coz default cant be accessed from diff package and not subclass(world)
    }
}


