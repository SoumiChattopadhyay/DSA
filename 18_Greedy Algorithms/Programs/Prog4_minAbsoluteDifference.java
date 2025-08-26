import java.util.Arrays;
public class Prog4_minAbsoluteDifference {
    public static void main(String[] args) {
        int a[]={1,2,3};
        int b[]={2,1,3};

        //Sort both the arrays
        Arrays.sort(a);
        Arrays.sort(b);

        int n=a.length,minAbsDiff=0;

        for(int i=0;i<n;i++){
            minAbsDiff+=Math.abs(a[i]-b[i]);
        }
        System.out.println("Min absolute diff of pairs="+minAbsDiff);
    }
}
