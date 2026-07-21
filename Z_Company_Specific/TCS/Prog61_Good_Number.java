import java.util.Scanner;

public class Prog61_Good_Number {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dig,sum=0;
        int i=n;
        while(i>0){
            dig=i%10;
            sum+=dig;
            i/=10;
        }
        if(n%sum==0)
            System.out.println("Good Number");
        else
            System.out.println("Bad Number");
        sc.close();
    }
}
// Name program as Main.java in Online Contests