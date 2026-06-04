public class Prog13_Nth_Root_of_an_Integer {
    static int findPower(int a, int n, int m){
        long ans=1;
        long base=a;
        while(n>0){
            if(n%2!=0){
                ans=ans*base;
                if(ans>m) return 2;
                n--;
            }
            else if(n%2==0){
                base=base*base;
                if(base>m) return 2;
                n=n/2;
            }
        }
        if(ans==m) return 1;
        return 0;//a^n
    }
    // Brute
    static int find_Nth_Root(int M, int N){
        for(int i=1;i<=M;i++){
            int num = findPower(i, N, M);
            if(num==1){
                return i;
            }
            else if(num==2){
                break;
            }
        }
        return -1;
    }
    // Optimal (Binary Search and answers)
    static int find_Nth_Root2(int M, int N){
        int low=1, high=M;
        while (low<=high) {
            int mid = low+(high-low)/2;
            int num = findPower(mid, N, M);
            if(num==1){//means num==M
                return mid;
            }
            else if(num==0){//means num<M
                low=mid+1;
            }
            else{// if num==2 means num>M
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
