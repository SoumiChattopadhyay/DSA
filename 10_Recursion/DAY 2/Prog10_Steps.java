//Given a non-negative integer num, return the number of steps to reduce it to zero.
public class Prog10_Steps {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
        System.out.println(numberOfSteps(8));
    }
    //TC: O(logN) as we are dividing the number by 2 in each step
    //SC: O(logN) as we are using recursion stack space
    //log₂(n) tells you how many times you can divide n by 2 before you reach 1.
    //2^p=r so here p is how many times u multiply 2 with itself to get r.
    //log₂(r)=p so here p is how many times u divide r by 2 to get 1.
    public static int numberOfSteps(int num) {
        if(num==0){
            return 0;
        }
        if(num%2!=0){
            num-=1;
        }else{
            num/=2;
        }
        return 1+numberOfSteps(num);
    }
}
