import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Prog8_find_subsets_using_iteration_remove_duplicates {
   public static void main(String[] args) {
        // System.out.println(subsetsDuplicate(new int[]{1,2,2}));
        System.out.println(subsetsDuplicate(new int[]{1,1,2,2}));
   }
   static List<List<Integer>> subsetsDuplicate(int[]arr){
        Arrays.sort(arr);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start=0;
        int end=0;
        for(int j=0;j<arr.length;j++){
            start=0;
            if(j>0 && arr[j]==arr[j-1]){
                start=end+1;//start = previous end+1
            }
            end=outer.size()-1;
            int n = outer.size();
            for(int i=start;i<n;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[j]);
                outer.add(inner);
            }
        }
        return outer;
   } 
}
