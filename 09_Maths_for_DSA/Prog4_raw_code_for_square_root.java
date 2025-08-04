public class Prog4_raw_code_for_square_root {
    public static void main(String[] args) {
       System.out.printf("%.3f",sqrt(40,3));//p is precision
    }
    public static double sqrt(int n, int p){//TC=O(log n). time taken by loop for precision calculation is less dominating term so not included in time complexity
        int s=0;
        int e=n;
        int m=s+(e-s)/2;
        double root=0.0;
        while(s<=e){
            m=s+(e-s)/2;
            if(m*m==n){
               root=m;
            }
            else if(m*m>n){
                s=m+1;
            }
            else{
                e=m-1;
            }
        }
        double inc=0.1;
        for(int i=0;i<p;i++){
            while(root*root<=n){
                root+=inc;
            }
            root-=inc;
            inc/=10;
        }
        return root;
    }
}
