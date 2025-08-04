import java.util.Arrays;
public class Prog45_setMismatch {
    public static int[] findErrorNums(int[] ar) {
        int i=0;
        while(i<ar.length){
            int correctPos=ar[i]-1;
            if(ar[i]!=ar[correctPos]){
                int temp=ar[i];
                ar[i]=ar[correctPos];
                ar[correctPos]=temp;
            }else{
                i++;
            }
        }
        for(int idx=0;idx<ar.length;idx++){
            if(ar[idx]!=idx+1){
                return new int[]{ar[idx],idx+1}; 
            }
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args) {
        int ar[]={1,2,2,4};
        System.out.println(Arrays.toString(findErrorNums(ar)));
    }
}
