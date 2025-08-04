public class Prog5_NewtonSQRT {
    public static double sqrt(int n){
        double x=n;// x is the guess of square root of n
        double root;// root is the actual square root of n
        while(true){
            root=0.5*(x+(n/x));//Formula
            if(Math.abs(root-x)<0.5){//error=|root-x|. Allowed error = 0.5 not more than that otherwise our guess x=root. and this is repeated, we can take allowed error as anything
                break;
            }
            x=root;
        }
        return root;
}
    public static void main(String[] args) {
        System.out.println(sqrt(40));
    }
}
