public class Prog00_Guess_Number_Higher_Or_Lower {
    static int guessNumber(int n){
        int low=1,high=n;
        while(low<=high){
            int mid=low+(high-low)/2;
            int g = guess(mid);
            if(g==0){
                return mid;
            }
            else if(g==-1){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
    static int guess(int yourGuess){
        int myGuess=7;
        if(yourGuess>myGuess) return -1;
        else if(yourGuess<myGuess) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        System.out.println(guessNumber(50));
    }
}