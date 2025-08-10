package nested;

public class A {
    //nested interface
    //nested interface can be declared as public, private or protected
    //but top-level interface has to be declared public or default
    public interface NestedInterface {
        boolean isOdd(int num);
    }
}
//dont make B public. public classes must be defined in their own files
class B implements A.NestedInterface{
    @Override
    public boolean isOdd(int num) {
       return (num & 1) == 1;
    }
}