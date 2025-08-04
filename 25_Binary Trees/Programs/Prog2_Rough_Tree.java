public class Prog2_Rough_Tree {//outer class
    int root1;//non-static instance variable of outer class
    static int root2;//static instance variable of outer class

    public class Node{//non-static inner classhas access                 
        int data;//non-static instance variable of inner class
        static int height;//static instance variable of inner class

        //This is a static method of inner class, we're trying to access non-static variable data in this so we need to create an object of this class. But this class is an inner class which is non-static so we first need to create an object of outer class and then access the inner class and create it's object
        public static void innerMethod() {
            // data=20;//wrong
            Prog2_Rough_Tree t = new Prog2_Rough_Tree();
            Node n = t.new Node();
            n.data=20;
            height=30;
            n.innerMethod2();
            // root1=40;//wrong.Cannot make a static reference to the non-static field root1. 
            t.root1=40;//correct
            root2=40;
            outerMethod();
            // outerMethod2();//wrong
            t.outerMethod2();
        }
        //This is a non-static method of inner class.
        public void innerMethod2() {
            // Node n = new Node();//correct. in non-static methods we can create objects of non-static inner class freely without needing an outer class object to access it
            data=20;//can access non-static vars in non-static methods without needing to creating object of class
            height=30;//static vars accessible in both static and non-static methods
            root1=40;
            root2=40;
            innerMethod();
            outerMethod();//correct
            outerMethod2();//correct
        }
}
    public static void outerMethod(){
        Prog2_Rough_Tree t = new Prog2_Rough_Tree();
        t.root1=40;
        root2=40;
        // data=20;//wrong
        // height=30;//wrong
        Node n = t.new Node();
        n.data=20;//correct
        Node.height=30;//correct
        // innerMethod();//wrong. The method innerMethod() is undefined for the type Tree
        // innerMethod2();//wrong
        Node.innerMethod();//correct
        n.innerMethod2();
    }
    public void outerMethod2(){
        root1=40;
        root2=40;
        outerMethod();
        // data=20;//wrong
        // height=30;//wrong
        Node n = new Node();
        n.data=20;//correct
        Node.height=30;//correct
        // innerMethod();//wrong
        // innerMethod2();//wrong
        Node.innerMethod();
        n.innerMethod2();
    }
    public static class Node2{
        int data;//non-static instance variable of inner class
        static int height;//static instance variable of inner class
        //This is a static inner class. So the only difference that separates it from the non-static inner class is that u dont need to create object of outer class first to access inner class and create inner class objects
        //static method of inner class
        public static void innerMethod(){
            Node2 n2 = new Node2();//perfectly ok
            // data=20;//wrong. 
            n2.data=20;
            height=30;
            n2.innerMethod2();
            Prog2_Rough_Tree t = new Prog2_Rough_Tree();
            t.root1=40;//root1 is a non-static variable and so its a property of outer class's object. So u need to first create the outer class object and then access it.
            root2=40;//root2 is a static variable and so its a property of outer class. Inner class 
            outerMethod();
            t.outerMethod2();
        }
        public void innerMethod2(){
            data=20;
            height=30;
            Prog2_Rough_Tree t = new Prog2_Rough_Tree();
            t.root1=40;//root1 is a non-static variable and so its a property of outer class's object. So u need to first create the outer class object and then access it.
            root2=40;//root2 is a static variable and so its a property of outer class.
        }
    }
}