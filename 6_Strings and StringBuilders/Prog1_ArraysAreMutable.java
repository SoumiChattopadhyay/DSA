import java.util.Arrays;

public class Prog1_ArraysAreMutable {
    public static void main(String[] args) {
        //Arrays are mutable
        int ar[]=new int[]{1,2,3,4,5};
        int[]arr=ar;
        System.out.println(Arrays.toString(arr));
        ar[1]=4;
        System.out.println(Arrays.toString(arr));
    }
}
