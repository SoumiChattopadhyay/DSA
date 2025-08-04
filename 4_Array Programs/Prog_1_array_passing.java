import java.util.Arrays;
public class Prog_1_array_passing {
    int findMin(int ar[]){
        // int i=0,min=Integer.MAX_VALUE;
        // for(i=0;i<ar.length;i++){
        //     if(ar[i]<min){
        //         min=ar[i];
        //     }
        // }
        // return min;
        Arrays.sort(ar);
        return ar[0];
    }
    public static void main(String[] args) {
        Prog_1_array_passing obj = new Prog_1_array_passing();
        int m = obj.findMin(new int[]{2,3,4,5,1,6});//creating the array and passing it
        System.out.println(m);
    }
    
}