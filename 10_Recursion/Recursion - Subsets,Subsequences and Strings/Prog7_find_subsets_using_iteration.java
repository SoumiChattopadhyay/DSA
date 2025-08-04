import java.util.ArrayList;
import java.util.List;
public class Prog7_find_subsets_using_iteration {
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }
    static List<List<Integer>> subsets(int[]arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int num:arr){
            int n = outer.size();
            for(int i=0;i<n;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
//     static List<List<Integer>> subsets(int[]arr){//array tar etai kaaj je ota elements 
// // gulo k debe ar tomake segulo niye list form korte hobe ar list of lists form korte hobe. 
// // I need a list to denote a subset and I need another list which will be a list of lists to denote the power set i.e. set of all subsets
//         List<List<Integer>> powerSet = new ArrayList<>();
//         powerSet.add(new ArrayList<>());//adding just one empty list to the list of lists
//         //powerset now kinda looks like this [[],...] and its waiting for other els.(lists) to get in since its a list of lists
//         for(int i=0;i<arr.length;i++){
//             //I need to either include the array el.(arr[i]) and form a subset or exclude it and form a subset
//             //First I'm taking the length of the powerSet list and storing it in n then I'm running a loop from 0 to <n
//             // I'm creating a new list(subSet) in every iteration
//             // subSet stores the list at jth position i.e. that empty list
//             int n=powerSet.size();//1,2,4
//             for(int j=0;j<n;j++){//0 to 0, 0 to 1,0 to 3
                
//                 //All these below lines are wrong as it is modifying the original lists not creating a copy of them 
//                 // List<Integer> subSet =powerSet.get(j);
//                 // List<Integer> subSet = new ArrayList<>();
//                 //subSet=powerSet.get(j);
                
//                 List<Integer> subSet = new ArrayList<>(powerSet.get(j));//this creates a copy. subset looks like this [],subset looks like this [] and subset looks like this [1],subset looks like this [] and subset looks like this [1] and subset looks like this [2] and subset looks like this [1,2]
//                 subSet.add(arr[i]);//now subset looks like this [1],subset looks like this [2] and subset looks like this [1,2], subset looks like this [3] and subset looks like this [1,3] and subset looks like this [2,3] and subset looks like this [1,2,3]
//                 powerSet.add(subSet);//now powerset looks like this [[],[1],...],powerset looks like this [[],[1],[2]...] and powerset looks like this [[],[1],[2],[1,2]...],powerset looks like this [[],[1],[2],[3]...] and powerset looks like this [[],[1],[2],[1,2],[3],[1,3]...] and powerset looks like this [[],[1],[2],[1,2],[3],[1,3],[2,3]...] and powerset looks like this [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]...]
//             }
//         }
//         return powerSet;
//     }
}
