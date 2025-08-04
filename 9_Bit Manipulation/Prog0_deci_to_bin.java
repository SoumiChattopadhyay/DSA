public class Prog0_deci_to_bin {
    public static void main(String[] args) {
        int n=67,i,count=-1,sum=0,dig;
        for(i=n;i!=0;i/=2){
            count++;
            dig=i%2;
            sum+=(int)Math.pow(10,count)*dig;
        }
        System.out.println(sum);
        System.out.println(5|9);//13
        System.out.println(~5);
    }
   
}
//javac MyProgram.java
// java MyProgram