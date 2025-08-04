public class Prog1_Recursion{
    public static void main(String[] args) {
        print1(1);
        print(1);//Recursive function: Function that calls itsef
    }
//All functs have same body structure - taking a no., printing it and calling another funct by passing no.+1 
    static void print1(int n){
        System.out.println(n);
        print2(2);
    }
    static void print2(int n){
        System.out.println(n);
        print2(3);
    }
    static void print3(int n){
        System.out.println(n);
        print2(4);
    }
    static void print4(int n){
        System.out.println(n);
        print2(5);
    }
    //funct body changes here
    static void print5(int n){
        System.out.println(n);
    }
    //Recursive function. Single funct doing the task done by the 5 functs above
    static void print(int n){
        //Base case/Special case. Funct body changes here. 
        if(n==5){
            System.out.println(n);
            return;
        }
        System.out.println(n);
        print(n+1);
    }//takes a no.(n),prints n, calls itself by passing n+1 
}