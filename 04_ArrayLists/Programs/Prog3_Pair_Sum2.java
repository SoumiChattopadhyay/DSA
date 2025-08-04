//  Sorted and Rotated ArrayList given [11,15,6,8,9,10] and targetSum=5 given. Find if any pair sum equals the targetSum
//pivot is the element around which rotation happens. Here its 10.
//but here breaking point or pivot is the point where the sorting rule breaks
//sorting rule - list1.get(i)<list1.get(i+1). like here it is at 15 to 6
import java.util.ArrayList;
public class Prog3_Pair_Sum2{

    public static boolean PairSum2(ArrayList<Integer> list1, int targetSum){
        //2 pointer approach - TC=O(n)
        int bp=-1, lp, rp, sum,n;
        n=list1.size();
        for(int i=0;i<list1.size();i++){
            if(list1.get(i)>list1.get(i+1)){
                bp=i;
                break;
            }    
        }
        rp=bp;
        lp=bp+1;
        while(lp!=rp){//dont write lp<rp here becoz it is rotated array so lp maybe greater than rp
            sum=list1.get(lp)+list1.get(rp);
            if(sum==targetSum){
                return true;
            }else if(sum<targetSum){
                lp=(lp+1)%n;
            }else{
                rp=(n+rp-1)%n;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(11);
        list1.add(15);
        list1.add(6);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        System.out.println(PairSum2(list1,16));
    }
}
