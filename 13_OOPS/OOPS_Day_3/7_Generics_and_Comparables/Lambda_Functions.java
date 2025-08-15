import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda_Functions{//one-liner functs that dont need funct names
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<5;i++){
            arr.add(i+1);
        }
        arr.forEach((item)->{System.out.print(item*2+" ");});//forEach() takes a Consumer type as parameter. Consumer is an interface that takes only one single type and returns no result.
        //item here represents every single item in the arraylist
        // forEach runs a for loop and iterates through the items of the list and performs a particular operation on them, operation means lambda function

        //Lambda expressions can be stored in Consumer type variables
        Consumer<Integer> fun = (item)->System.out.println(item*2);//import it first
        arr.forEach(fun);//for every item of arraylist perform the fun operation
    
    //To work with multiple values u can create an interface and we can store lambda functions into variables of type Interface. Consumer was also an Interface
    Operation sum = (a,b)->a+b;
    Operation diff = (a,b)->a-b;
    Operation prod = (a,b)->a*b;
    Operation div = (a,b)->{return (b!=0)?(a/b):0;};
    //Each one is not just a random lambda — it’s actually a full implementation of the operate() method.

    Lambda_Functions myCalculator = new Lambda_Functions();
    System.out.println(myCalculator.calculate(1,2,sum));
    System.out.println(myCalculator.calculate(7,2,diff));
    System.out.println(myCalculator.calculate(3,2,prod));
    System.out.println(myCalculator.calculate(9,0,div));
    
}
    // Create a method named calculate which takes a lambda expression as a parameter:
    private int calculate(int a,int b,Operation op){//op is a variable of type Interface that points to a Lambda function. Previously ur class implemented the interface so implemented the interface's abstract method and executed it using the class object. But here the class doesnt implement the interface, it stores some lambda functs in the Interface type ref variables.And inside it's another method calculate when operate() method of Interface is called via an Interface type ref var. automatically the operate method's body becomes the lambda funct the ref. var is pointing to as this is a single-method interface.
        return op.operate(a,b);//control goes to operate method but it is abstract method so it's body becomes the respective lambda function 
    }
    
    //convert this into lambda function
    int sum(int a,int b){
        return a+b;
    }
}
//a single-method interface named Operation which is a mimic of Consumer interface except that its method takes 2 arguments instead of 1
interface Operation{//dont make it public. public interfaces must be defined in its own file.
        int operate(int n1, int n2);
}//This is a functional interface → it has exactly one abstract method (operate).
//Because it’s a functional interface, you can write a lambda that automatically becomes an implementation of operate().


// Operation sum = (a, b) -> a + b;
// is equivalent to:

// Operation sum = new Operation() {
//     @Override
//     public int operate(int a, int b) {
//         return a + b;
//     }
// };
// The (a, b) -> ... syntax replaces the whole anonymous class.

//An anonymous class in Java is a class without a name that you create and use on the spot, usually when you only need it once.

//Java variables used in lambdas must be effectively final (you can’t change them)
//Cant find sum like this
// int sum=0;
// arr.forEach((item)->{
//     // sum+=item;//compiler error because Java variables used in lambdas must be effectively final (you can’t change sum inside forEach directly like that
// });
// System.out.println(Arrays.toString(arr));//error coz it works only with arrays not arraylists