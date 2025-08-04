// Find all possible combinations of dice rolls to achieve target sum

import java.util.ArrayList;

public class Prog11_dice {
    public static void main(String[] args) {
        dice("", 4);
        System.out.println(diceRet("", 4));
    }
    static void dice(String p,int targetSum){
        if(targetSum==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=6 && i<=targetSum;i++){
            dice(p+i, targetSum-i);
        }
    }
     static ArrayList<String> diceRet(String p,int targetSum){
        if(targetSum==0){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> rem = new ArrayList<>();
        for(int i=1;i<=6 && i<=targetSum;i++){
            rem=diceRet(p+i, targetSum-i);
            list.addAll(rem);
        }
        return list;
    }
    // if no. of faces is given
    static void dice2(String p,int targetSum, int faces){
        if(targetSum==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=faces && i<=targetSum;i++){
            dice2(p+i, targetSum-i,faces);
        }
    }
}
