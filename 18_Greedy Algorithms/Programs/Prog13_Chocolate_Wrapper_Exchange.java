public class Prog13_Chocolate_Wrapper_Exchange {
    // Chocolate Wrapper Exchange
    //  money=15, cost=1, wrapperNeeded=3 => First buy 15 chocolates, Give 5 wrappers and get 5 chocolates, Then give 3 wrappers and get 1 chocolate So you ate 21 chocolates
    static int funct2(int money, int cost, int wrapperNeeded){
        int chocs = money/cost;
        int wrappers = chocs;
        while(wrappers>=wrapperNeeded){
            int newChocs = wrappers/wrapperNeeded; 
            int remainingWrappers = wrappers % wrapperNeeded;

            chocs += newChocs;
            wrappers = newChocs + remainingWrappers;
        }
        return chocs;
    }
    public static void main(String[] args) {
        System.out.println(funct2(15, 1, 3));
    }
}
