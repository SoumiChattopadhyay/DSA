public class Prog12_Nth_Root_of_an_Integer {
    static int multiply(int i, int n){
        return (int)Math.pow(i,n);
    }
    // Brute
    static int find_Nth_Root(int M, int N){
        for(int i=1;i<=M;i++){
            int num = multiply(i, N);
            if(num==M){
                return i;
            }
            else if(num>M){
                break;
            }
        }
        return -1;
    }
    // Optimal (Binary Search and answers)
    static int find_Nth_Root2(int M, int N){
        int low=1, high=M;
        while (low<high) {
            int mid = low+(high-low)/2;
            int num = multiply(mid, N);
            if(M==num){
                return mid;
            }
            else if(M>num){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(find_Nth_Root(27,3));
        System.out.println(find_Nth_Root(69,4));
        System.out.println(find_Nth_Root2(27,3));
        System.out.println(find_Nth_Root2(69,4));
    }
}
