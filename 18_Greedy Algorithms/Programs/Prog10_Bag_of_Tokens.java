import java.util.Arrays;

public class Prog10_Bag_of_Tokens{
    static int funct1(int[] tokens, int power){//TC=O(NlogN)
        Arrays.sort(tokens);
        int score=0,maxScore=0;
        int left=0;
        int right=tokens.length-1;
        while(left<=right){
            // Case 1: Enough power to buy smallest token
            if(power>=tokens[left]){
                power-=tokens[left];//spend power
                score++;//gain score
                left++;//move left pointer
                maxScore = Math.max(maxScore, score);//track maximum score
            }
            // Case 2: Not enough power, sell biggest token
            else if(score>0){
                power+=tokens[right];//gain power
                score--;//lose one score
                right--;//move right pointer
            }
            // Case 3: No move possible
            else{
                break;
            }
        }
        return maxScore;
    }
    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        int power=200;
        System.out.println(funct1(tokens, power));
    }
}