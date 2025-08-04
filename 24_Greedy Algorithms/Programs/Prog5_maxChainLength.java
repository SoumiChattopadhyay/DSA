import java.util.*;
public class Prog5_maxChainLength {
    public static void main(String[] args) {//O(nlogn)
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};

        Arrays.sort(pairs,Comparator.comparingInt(o->o[1]));//sorting the 3D array based on 2nd no.
        
        //Taking first pair into consideration
        int chainEnd = pairs[0][1];
        int chainLength=1;

        //We have to select pairs such that the 2nd no. of a pair is lesser than the first no. of next pair
        for(int i=1;i<pairs.length;i++){
            if(chainEnd<pairs[i][0]){
                chainLength++;
                chainEnd=pairs[i][1];
            }
        }
        System.out.println("Max chain length="+chainLength);
    }
}
