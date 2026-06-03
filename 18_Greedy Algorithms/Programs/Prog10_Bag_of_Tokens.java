import java.util.Arrays;

public class Prog10_Bag_of_Tokens{
    static int funct1(int[] tokens, int power){//TC=O(NlogN)
        Arrays.sort(tokens);
        int score=0,maxScore=0;
        int left=0;
        int right=tokens.length-1;
        while(left<=right){//Greedy approach : Use Power to play the smaller tokens, and use score to play the bigger tokens becoz we have a comdition that only when we have a power greater than tokens[i] we can play that token but for score there is no such restriction
            // Case 1: Enough power to play smallest token
            if(power>=tokens[left]){
                power-=tokens[left];//spend power
                score++;//gain score
                left++;//move left pointer
                maxScore = Math.max(maxScore, score);//track maximum score
            }
            // Case 2: Not enough power, play biggest token
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