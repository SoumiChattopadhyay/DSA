public class Prog6_passing_concept {
    public static void main(String[] args) {
        funct(5);
    }
     // concept
     static void funct(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n+" ");
        // funct(n--); //Passing 5 first then decrementing its value, so in each rec. functio call 5 is only passed 
        // so it keeps printing 5 then stops due to StackOverflow error
        funct(--n); // 5 4 3 2 1
    }
}
