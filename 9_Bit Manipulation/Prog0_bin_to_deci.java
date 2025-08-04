public class Prog0_bin_to_deci {
    public static void main(String args[]){
        int n=100;
        int sum=0,count=-1,i,dig;
        for(i=n;i>0;i/=10){
            count++;
            dig=i%10;
            sum+=(int)Math.pow(2,count)*dig;
        }
        System.out.println(sum);
    }
}