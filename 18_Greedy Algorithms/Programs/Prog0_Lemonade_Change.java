 // Lemonade Change : Shopkeeper sells 5$ lemonade, multiple customers come and pay using $5,$10 and $20. Shopkeeper must return the correct change. Shopkeeper initially has no money. Return true if shopkeeper can return the correct bills else return false.
// We need to just maintain count of how many 5$ and 10$ coins shopkeeper has after every transaction. We dont need to count the 20$ coins he has. Because he never would have to give a 20$ change to the customer.
// Because 3 cases : customer gives 10$ shopkeeper must return 5$, customer gives 20$ then shopkeeper must return 15$ either 10+5 or 5+5+5
public class Prog0_Lemonade_Change {
    static boolean funct1(int[] bills){//TC=O(n)
        int five=0, ten=0;//initially shopkeeper has no bills
        for(int bill:bills){
            if(bill==5) five++;
            else if(bill==10){
                if(five>0){
                    five--;
                    ten++;
                } 
                else return false;
            }
            else{//(bill==20)
                if(ten>0 && five>0){
                    five--;
                    ten--;
                }
                else if(five>2){
                    five-=3;
                }
                else return false;
            }
        }
        return true;
    }
    static boolean funct2(int[] bills){
        int n = bills.length;
        int five=0, ten=0;//initially shopkeeper has no bills
        int i=0;
        while (i<n) {
            if(bills[i]==5) five++;
            else if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                } 
                else return false;
            }
            else{//(bills[i]==20)
                if(ten>0 && five>0){
                    five--;
                    ten--;
                }
                else if(five>2){
                    five-=3;
                }
                else return false;
            }
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        int[] arr = {5,5,5,10,20};
        System.out.println(funct1(arr));
        System.out.println(funct2(arr));
    }
}
