import java.util.ArrayList;
public class Prog6_Factors {
    public static void main(String[] args) {
        System.out.printf("The factors of %d are:\n",36);
        factors2(36);
    }
    // O(n)
    static void factors1(int n) {
        for (int i=1;i<=n;i++) {
            if (n%i==0) {
                System.out.print(i + " ");
            }
        }
    }

   // TC= O(sqrt(n)). But els wont be printed in sorted order here. We notice a pattern - i els are in asc. order and the n/i els. are in desc order so we can store the n/i els in an arraylist and print the arraylist from the end
   static void factors2(int n) {
    for (int i = 1; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            if (n/i == i) {
                System.out.print(i + " ");
            }else {
                System.out.print(i + " " + n/i + " ");
            }
        }
    }
}

// both time and space with be O(sqrt(n))
    static void factors3(int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                if(n/i==i){
                    System.out.print(i+" ");
                }else{
                    // System.out.print(i+" "+n/i+" ");
                    System.out.print(i+" ");
                    list.add(n/i);
                }
            }
        }
        for(int i=list.size()-1;i>=0;i--){
            System.out.print(list.get(i)+" ");
        }
    }
}
