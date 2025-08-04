import java.util.ArrayList;
import java.util.List;
public class Prog44_findAllDuplicates {
    public static List<Integer> findAllDuplicates(int ar[]){
        List<Integer> d = new ArrayList<>();
        int i=0;
        while(i<ar.length){
            int correctIdx=ar[i]-1;
            if(ar[correctIdx]!=ar[i]){
                int temp=ar[i];
                ar[i]=ar[correctIdx];
                ar[correctIdx]=temp;
            }else{
                i++;
            }
        }
        for(int j=0;j<ar.length;j++){
            if(ar[j]!=j+1){
                d.add(ar[j]);
            }
        }
        return d;
    }
    public static void main(String[] args) {
        int ar[]={4,3,2,7,8,2,3,1};
        System.out.println(findAllDuplicates(ar));
    }
}
