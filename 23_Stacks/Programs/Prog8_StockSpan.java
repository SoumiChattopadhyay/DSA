import java.util.Stack;
public class Prog8_StockSpan {//TC=O(n)
    public static void findSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for(int i=1;i<stocks.length;i++){
            int currPrice=stocks[i];
            while(!s.isEmpty() && stocks[s.peek()]<=currPrice){
                s.pop();//pop all the idxs of els which are less than equal to currPrice
            }
            if(s.isEmpty()){//means that all the els were less than equal to currPrice
                span[i]=i+1;
            }else{
                int prevHigh=s.peek();
                span[i]=i-prevHigh;
            }
            s.push(i);//pushing every idx in stack
        }
    }
    public static void main(String[] args) {
        int stocks[] = {100, 80, 60, 70, 60, 75, 85};
        int span[] = new int[stocks.length];

        findSpan(stocks, span);

        for (int s : span) {
            System.out.print(s + " ");
        }
    }
}
//Brute force approach : TC=O(n^2)
// class StockSpan {
//     public static void findSpan(int[] stocks, int[] span) {
//         for (int i = 0; i < stocks.length; i++) { //Outer loop runs n times
//             for (int j = 0; j <= i; j++) { //Inner loop runs i+1 times
//                 if(stocks[j]<=stocks[i])
//                 span[i]++;
//                 else
//                 span[i]=0;
//             }
//         }
//     }

//     public static void main(String[] args) {
//         int stocks[] = {100, 80, 60, 70, 60, 75, 85};
//         int span[] = new int[stocks.length];

//         findSpan(stocks, span);

//         for (int s : span) {
//             System.out.print(s + " ");
//         }
//     }
// }

