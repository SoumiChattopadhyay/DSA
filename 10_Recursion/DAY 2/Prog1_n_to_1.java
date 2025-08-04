public class Prog1_n_to_1 {
    // TC: O(n) for all 3 functions
    // SC: O(n) for all 3 functions (due to recursion stack space)
    public static void main(String[] args) {
        print_n_to_1(5);
        System.out.println();
        print_1_to_n(5);
        System.out.println();
        print_n_to_1_and_1_to_n(5);
    }
    public static void print_n_to_1(int n){
        // Base condition: Condition where our recursion will stop making new function calls
        // Recursive function without base condition will give : Stack Overflow Error
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        print_n_to_1(n-1);
    }
    
    public static void print_1_to_n(int n){
        if(n==0){
            return;
        }
        print_1_to_n(n-1);
        System.out.print(n+" ");
    }

    public static void print_n_to_1_and_1_to_n(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        print_n_to_1_and_1_to_n(n-1);
        System.out.print(n+" ");
    }
}
