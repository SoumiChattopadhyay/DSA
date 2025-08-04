import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
public class Prog4_lonely_number {
    public static ArrayList<Integer> findLonely(ArrayList<Integer> nums){
        Collections.sort(nums);
        ArrayList<Integer> lonelyList = new ArrayList<>();

        for(int i=1;i<nums.size()-1;i++){
            if((nums.get(i-1)<nums.get(i)-1)&&(nums.get(i+1)>nums.get(i)+1)){
                lonelyList.add(nums.get(i));
            }
        }
        if(nums.size()==1){
            lonelyList.add(nums.get(0));
        }
        if(nums.size()>1){
        if(nums.get(1)>nums.get(0)+1){
            lonelyList.add(nums.get(0));
        }
        if(nums.get(nums.size()-2)<nums.get(nums.size()-1)-1){//dont write else if then it wouldnt be checked if first condtn is true
            lonelyList.add(nums.get(nums.size()-1));
        }
    }
        return lonelyList;
    }
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(10, 6, 5, 8));//Initialisation of ArrayList with value
        ArrayList<Integer> nums2 = new ArrayList<>(Arrays.asList(1,3,5,3));//Initialisation of ArrayList with value
        System.out.println(findLonely(nums));
        System.out.println(findLonely(nums2));
    }
}
