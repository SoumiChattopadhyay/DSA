import java.util.LinkedList;//importing LinkedList class of list interface
//import java.util.*;//importing all classes and interfaces
public class Prog9_LLCollectionFramework {
    public static void main(String[] args) {
        //Like ArrayLists we can only store objects in this LinkedList. we have to use class data type not primitive data type
        LinkedList<Integer> ll = new LinkedList<>();

        ll.addFirst(0);
        ll.addLast(1);
        ll.addLast(2);
        System.out.println(ll);//[0, 1, 2]

        
        ll.removeFirst();
        ll.removeLast();
        System.out.println(ll);//[1]
    }
}
