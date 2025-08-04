public class Prog28_tiling_prob {
    public static int tiling(int n){//Fills 2 x n area floor/ n breadth floor. Arrangement can be either vertical or horizontal.
        //base case
        if(n==0 || n==1)
           return 1;
        //kaam
        //vertical choice (1st tile vertical then what are the other tile arrangements for n-1 part)
        int fnm1 = tiling(n-1);// vertical choice lene pe kitni ways bachengi
        //horizontal choice
        int fnm2 = tiling(n-2);
         
        return fnm1 + fnm2;//Total ways
        //return tiling(n-1)+tiling(n-2);
    }
    public static void main(String[] args) {
        System.out.println(tiling(241));// n is the breadth of the floor
    }
}
//2x1(LengthxBreadth of each tile)
//2xn(LengthxBreadth of floor)