import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Prog25_Four_Sum {
    static List<List<Integer>> funct1(int[] arr,int target){
        int n=arr.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++){
                        long sum = arr[i]+arr[j];
                        sum += arr[k];
                        sum += arr[l];//Add in 3 steps instead of one step to avoid Integer Limit Exceeding on Summation
                        if(sum==target){
                            List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                            Collections.sort(temp);
                            set.add(temp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }
    static List<List<Integer>> funct2(int[] arr,int target){
        int n=arr.length;
        Set<List<Integer>> ansSet = new HashSet<>();

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Integer> set = new HashSet<>();
                for(int k=j+1;k<n;k++){
                    long sum = arr[i]+arr[j];
                    sum+=arr[k];
                    long fourth = target-sum;
                    if(set.contains((int)fourth)){
                        List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],(int)fourth));
                        Collections.sort(temp);
                        ansSet.add(temp);
                    }
                    set.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(ansSet);
    }
    static List<List<Integer>> funct3(int[] arr,int target){
        int n=arr.length;
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(arr);
        
        for(int i=0;i<n;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<n;j++){
                if(j>i+1 && arr[j]==arr[j-1]) continue; //if j is not the first el and arr[j]=arr[j-1] then continue coz its a duplicate
                int k=j+1;
                int l=n-1;
                while(k<l){
                    long sum = arr[i]+arr[j];
                    sum+=arr[k];
                    sum+=arr[l];
                    if(sum<target){
                        k++;
                    }
                    else if(sum>target){
                        l--;
                    }
                    else{
                        List<Integer> temp = new ArrayList<>(Arrays.asList(arr[i],arr[j],arr[k],arr[l]));
                        ans.add(temp);
                        k++;
                        l--;
                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l]==arr[l+1]) l--;
                    }
                }
                
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr={1,0,-1,0,-2,2};
        int target=0;
        System.out.println(funct1(arr, target));
        System.out.println(funct2(arr, target));
        System.out.println(funct3(arr, target));
    }
}
