// Sorted ArrayList given [1,2,3,4,5] and targetSum=5 given. Find if any pair sum equals the targetSum
import java.util.ArrayList;
public class Prog2_Pair_Sum1{
    public static boolean PairSum(ArrayList<Integer> list1, int targetSum){
        int sum,lp,rp;
        //brute force TC=O(n^2) - this method doesnt need sorted array but the next one desperately needs it
    //     for(int i=0;i<list1.size();i++){
    //         for(int j=i+1;j<list1.size();j++){
    //             sum=(list1.get(i)+list1.get(j));
    //             if(sum==targetSum)
    //                 return true;
    //         }
    //     }
    //     return false;

    //2 pointer approach TC=O(n)because if lp moves d times then rp moves n-d times so total n times
    lp=0;
    rp=list1.size()-1;
    while(lp<rp){
        sum=list1.get(lp)+list1.get(rp);
        if(sum==targetSum){
            return true;
        }else if(sum<targetSum){//Since it is a sorted array(ascending order) going rightward can increase the possibility of getting increased sum
            lp++;
        }else{//Similarly now going left toward can increase the possibility of getting lesser sum 
            rp--;
        }
    }
    return false;
}


    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        System.out.println(PairSum(list1,5));
    }
}
