import java.util.HashMap;
import java.util.Map;

public class Prog11_Count_Subarrays_with_K_different_integers {
    static int funct1(int[] arr, int k){
        int n=arr.length;
        int cnt=0;
        for(int i=0;i<n;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=i;j<n;j++){
                map.put(arr[j],map.getOrDefault(arr[j], 0)+1);
                if(map.size()==k){
                    cnt++;
                }
                else if(map.size()>k){
                    break;
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,1,3,4};
        int k=3;
        System.out.println(funct1(arr, k));
    }
}
