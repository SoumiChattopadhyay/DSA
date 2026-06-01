import java.util.HashMap;
import java.util.Map;

public class Prog14_Majority_Element {
    // Brute
    // TC=O(N^2), SC=O(1)
    static int find1(int[] arr){
        int N=arr.length;
        for(int i=0;i<N;i++){
            int cnt=0;
            for(int j=0;j<N;j++){
                if(arr[i]==arr[j]){
                    cnt++;
                }
            }
            if(cnt>N/2){
                return arr[i];
            }
        }
        return -1;
    }
    // Better
    // TC=O(N), SC=O(N)
    static int find2(int[] arr){
        int N=arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<N;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()>(N/2)){
                return entry.getKey();
            }
        }
        return -1;
    }
    // Optimal
    // Moore's Voting Algorithm
    // TC=O(N), SC=O(1)
     static int find3(int[] arr){
        int N=arr.length;

        int el=arr[0];
        int cnt=0;
        
        // Apply Moore's Voting Algo.
        for(int i=0;i<N;i++){
            if(cnt==0){
                el=arr[i];
                cnt=1;
            }
            else if(arr[i]==el){
                cnt++;
            }
            else{
                cnt--;
            }
        }

        // Verify if majority el. exists if we consider the entire array
        int cnt1=0;
        for(int i=0;i<N;i++){
            if(arr[i]==el){
                cnt1++;
            }
        }
        if(cnt1>(N/2))
            return el;

        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        System.out.println(find1(arr));
        System.out.println(find2(arr));
        System.out.println(find3(arr));
    }
}
