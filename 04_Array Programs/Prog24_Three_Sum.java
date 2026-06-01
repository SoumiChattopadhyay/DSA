import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Prog24_Three_Sum {
    static List<List<Integer>> funct1(int[] arr){
        int n=arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(arr[i]+arr[j]+arr[k]==0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    // Better Sol
    static List<List<Integer>> funct2(int[] arr){
        int n=arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for(int i=0;i<n;i++){
            Set<Integer> hs = new HashSet<>();
            for(int j=i+1;j<n;j++){
                int third = -(arr[i]+arr[j]);
                if(hs.contains(third)){
                    List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i],arr[j],third));
                    Collections.sort(temp);
                    ans.add(temp);
                }
                hs.add(arr[j]);
            }
        }
        return new ArrayList<>(ans);
    }

    // Optimal Sol(Two Pointer Approach)
    static List<List<Integer>> funct3(int[] arr){
        int n=arr.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);//O(NlogN)
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            int j = i+1;
            int k = n-1;
            while(j<k){
                int sum = arr[i]+arr[j]+arr[k];
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                    List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k]));
                    ans.add(temp);
                    j++;
                    k--;
                    while(j<k && arr[j]==arr[j-1]) j++;//keep moving j until its not equal to previous j value and make sure boundary crossing(j crossing k) doesnt happen coz we want triplet in sorted order so we want i  j  k not i  k  j
                    while(j<k && arr[k]==arr[k+1]) k--;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1,0,-1,2,-1,4};

        System.out.println(funct1(arr));
        System.out.println(funct2(arr));
    }
}
