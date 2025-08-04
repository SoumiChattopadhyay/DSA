import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Prog5_find_subsets_using_recursion {
    public static void main(String[] args) {
        System.out.println(outer);//[]
        subsets(new int[]{1,2,3},new int[0],0);
        subsets(new int[]{1,2,3},new ArrayList<>(),0);//to pass a list you cant just pass [1,2,3,4] you have to pass new ArrayList<>()
        System.out.println(outer);
    }
    static void subsets(int[]arr,int[] ans,int i){
        if(i==arr.length){
            System.out.println(Arrays.toString(ans));
            return;
        }
        int num=arr[i];

        // Include current element(num)(at the end of ans array)
        // Make a copy of ans array(processed array), add the element at the end of it, and recursively elements keep adding.
        // You need to make a copy because Java arrays are passed by reference — if you modify ans directly, it affects all other recursive branches that use the same ans.
        // So by the time your code backtracks and reaches the previous recursive call the array has already been modified so that particular array of that particular recursive call is not existing
        // So the below code is wrong in this case and also because ans length is 0 so 0-1=-1 leads to IndexOutofBounds error
        // ans[ans.length-1]=num;
        // subsets(arr,ans,i+1);
        // Why not newAns[i] ? Becaz each time a new array(copy of ans) is created so if u take i first time u wud insert at 0 pos, then at 1 pos, then like this i would exceed and give IndexOutOfBoundsError
        int newAns[]=Arrays.copyOf(ans, ans.length+1);
        newAns[newAns.length-1]=num;//newAns array is a copy of ans with one extra space, and we want to add the new element at the end, not at index i. So thats why insert from back
        subsets(arr,newAns,i+1);
        
        // Exclude current element(num)
        subsets(arr,ans,i+1);
    }

    static List<List<Integer>> outer = new ArrayList<>();
    static void subsets(int[]arr,List<Integer> inner, int i){
       if(i==arr.length){
            outer.add(inner);
            // System.out.println(inner);
            return;
       }
       int num=arr[i];
        //Include num
        List<Integer> newInner = new ArrayList<>(inner);
        newInner.add(num);
        subsets(arr, newInner, i+1);    
       //Exclude num
       subsets(arr,inner,i+1);
    }
    //Q: Use 2 lists to store and print all the subsets that can be formed imagining the provided array as a set
    static List<List<Integer>> subsets2(int[]arr,List<Integer> inner, int i){
       if(i==arr.length){
            List<List<Integer>> outer = new ArrayList<>();//local variable dominating global variable here
            outer.add(inner);
            return outer;
       }
       int num=arr[i];
        //Include num
        List<Integer> newInner = new ArrayList<>(inner);
        newInner.add(num);//if we wrote inner.add then the list would have been modified and the original list could not be restored which is crucial in this kind of a recursive tree problem. earlier we wereusing the substring method so the original array was not affected
        List<List<Integer>> left = subsets2(arr, newInner, i+1);    
        //Exclude num
        List<List<Integer>> right =subsets2(arr,inner,i+1);
        left.addAll(right);
        return left;
    }
}
//consider the requirements of any single recursive call its gonna match with the others
//see that it doesnt affect the overall tree
//consider the requirements of the last call after which control must return
// ✅ ArrayList<> is a real class, so you can create objects from it.
// ✅ List is just an interface, like a rulebook — you can't create objects directly from it.