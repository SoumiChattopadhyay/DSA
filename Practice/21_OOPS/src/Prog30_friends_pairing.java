public class Prog30_friends_pairing {
    public static int friends_pairing(int n){
        //base case
        if(n==1 || n==2)
            return n;
        //kaam
        //choosing single
        int fnm1 = friends_pairing(n-1);
        //choosing pair
        int fnm2 = friends_pairing(n-2);
        int totalPairs = (n-1)*fnm2;
        int totalWays = fnm1 + totalPairs;
        return totalWays;
        //return friends_pairing(n-1) + (n-1)*friends_pairing(n-2);
    }
    public static void main(String[] args) {
        System.out.println(friends_pairing(3));
    }
}
