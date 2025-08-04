import java.util.Arrays;
public class Prog9_Candy {
    public static void main(String[] args) {
        Prog9_Candy obj = new Prog9_Candy();
        System.out.println(obj.candy(new int[]{1,2,87,87,2,1}));
    }
    public int candy(int[] ratings) {
        int candies[]=new int[ratings.length];
        //everyone must get atleast one candy
        for(int i=0;i<candies.length;i++){
            candies[i]=1;
        }
        for(int i=1;i<candies.length;i++){
            if(ratings[i]>ratings[i-1]){
                candies[i]=candies[i-1]+1;
            }
        }
        for(int i=candies.length-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]){
                candies[i]=Math.max(candies[i],candies[i+1]+1);
            }
        }
        System.out.println(Arrays.toString(ratings));
        System.out.println(Arrays.toString(candies));
        int sum=0;
        for(int candy:candies){
            sum+=candy;
        }
        return sum;
    }
}
