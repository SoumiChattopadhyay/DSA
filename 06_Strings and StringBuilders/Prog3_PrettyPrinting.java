import java.util.Arrays;
public class Prog3_PrettyPrinting {
    public static void main(String[] args) {
        //Function overloading and Function overriding
        System.out.println(56);//56
        System.out.println("Soumi");//Soumi
        System.out.println(Arrays.toString(new int[]{2,3,4}));//[2,3,4]
        // Integer num = new Integer(56);
        // System.out.println(num.toString());//56
        // System.out.println(num);//56

        //Placeholders or Format Specifiers and Pretty Printing
        float a=35.678696f;
        System.out.printf("%n %.2f",a);//Gives the no. upto two decimal places & also rounds off the no. so we get 35.68 not 35.67
        System.out.printf("%n Pie: %.3f",Math.PI);
        System.out.printf("%n %d",98);
        System.out.printf("%n %s and welcome %s","Hello","Soumi" );
        System.out.printf("%n %c",'z');
    }
}
