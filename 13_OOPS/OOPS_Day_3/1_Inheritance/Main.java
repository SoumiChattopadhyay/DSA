public class Main {
    public static void main(String[] args) {
        
        Box box1 = new Box(4,5,6);
        System.out.println(box1.h+" "+box1.w);//cant access box.l coz its private

        BoxWeight boxWt2 = new BoxWeight();
        System.out.println(boxWt2.w+" "+boxWt2.h+" "+boxWt2.weight);//-1.0 -1.0 -1.0 -1.0
        //Even if you don’t explicitly write super(), the compiler automatically calls the no-arg constructor of the parent class before executing the child constructor.
        // can't access private parent class variables outside the parent class
        
        BoxWeight boxWt3 = new BoxWeight(2,3,4,8);
        System.out.println(boxWt3.w+" "+boxWt3.h+" "+boxWt3.weight);
        
        // Parent class referencing to a child object.This is valid and is called upcasting.Because in Java, a child is-a parent.That is, if Child extends Parent, then a Child is also a Parent.
        // If Reference to a sub-class object is assigned to a super class ref.var, we will have access to only those parts of object which are defined in the super class
        //ref variable of type Box pointing to object of type BoxWeight
        Box box5 = new BoxWeight(2,3,4,8);//what variables the object has access to depends on the type of the ref. var of that object
        //It is the type of the ref.var not the type of the object that determines what members can be accessed. So w(member of Box) can be accessed but weight(member of BoxWeight) cannot be accessed
        
        // box5 is a Parent type reference variable.
        // new BoxWeight(2,3,4,8) is a Child object, which includes everything from Parent + extra stuff from Child.
        // So box5 only sees the Parent part of the Child object.
        // box5.l;     // allowed — exists in Parent 
        // box5.h;    // allowed — exists in Parent 
        // box5.w;    // allowed — exists in Parent 
        // box5.weight;// NOT allowed — weight is not in Parent 
        System.out.println(box5.w);//correct
        // System.out.println(box5.weight);//wrong

        // Trying to reference child class to a parent object. This is invlaid because parent class is not a child class.
        // there are many variables in both parent and child classes
        // Here,you are given access to variables that are in the child class coz ref. var type is BoxWeight
        // hence, you should have access to weight variable
        // this also means, that the ones you are trying to access should be initialised
        // but here, when the obj itself is of type parent class, how will you call the constructor of child class - // Above classes(Box) have no idea about below classes(BoxWeight) but below classes know about above classes
        // this is why error :-
        // BoxWeight box6 = new Box(2,3,4);//error
        System.out.println("--------------------------------------");
        BoxPrice bp1=new BoxPrice();
        System.out.println(bp1.h+" "+bp1.w+" "+bp1.weight+" "+bp1.price);
    }
}
