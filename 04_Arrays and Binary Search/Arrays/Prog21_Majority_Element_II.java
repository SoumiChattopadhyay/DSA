import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Prog21_Majority_Element_II {
    // Optimal Approach
    // TC=O(N),SC=O(1)
    static List<Integer> funct3(int[] arr){
        int n=arr.length;
        int cnt1=0,cnt2=0,el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(cnt1==0 && arr[i]!=el2){
                el1=arr[i];
                cnt1=1;
            }
            else if(cnt2==0 && arr[i]!=el1){
                el2=arr[i];
                cnt2=1;
            }
            else if(arr[i]==el1) cnt1++;
            else if(arr[i]==el2) cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0;
        cnt2=0;
        for(int i=0;i<n;i++){
            if(el1==arr[i]){
                cnt1++;
            }
            else if(arr[i]==el2){
                cnt2++;
            }
        }
        
        List<Integer> ls = new ArrayList<>();
        int min = (int)(n/3)+1;
        if(cnt1>=min){
            ls.add(el1);
        }
        if(cnt2>=min){
            ls.add(el2);
        }

        Collections.sort(ls);

        return ls;
    }

    // Better Approach
    // TC=O(N), SC=O(N)/O(N^2)
    static List<Integer> funct2(int[] arr){
        Map<Integer,Integer> mp = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        int n = arr.length;
        int min = (int)(n/3)+1;

        for(int i=0;i<n;i++){
            //increase count of el in Hashmap
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            // check if el's count=min
            if(mp.get(arr[i])==min){
                ls.add(arr[i]);
            }
            // check if list has 2 els
            if(ls.size()==2){
                break;
            }
        }
        // O(2 log 2) = O(1) (Takes const time in sorting)
        Collections.sort(ls);

        return ls;
    }
    
    // Brute Force 
    // TC=O(N^2), SC=O(1)
    static List<Integer> funct1(int[] nums){
        List<Integer> ls = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            // avoid checking same element again
            if(ls.size()==0 || !ls.contains(nums[i])) {
                int count=0;
                // count frequency of nums[i]
                for (int j=0;j<n;j++) {
                    if (nums[j]==nums[i]) {
                        count++;
                    }
                }
                // check if > n/3
                if (count>n/3) {
                    ls.add(nums[i]);
                }
            }
            // 2 elements filled in list so break
            if(ls.size()==2) break;
        }
        return ls;
    }
    public static void main(String[] args) {
        int[] arr={1,1,1,3,2,2,2};
        System.out.println(funct1(arr));
        System.out.println(funct2(arr));
        System.out.println(funct3(arr));
    }
}
