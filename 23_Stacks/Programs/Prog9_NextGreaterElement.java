import java.util.Stack;
public class Prog9_NextGreaterElement {
    public static void findNextGreaterElement(int[] arr, int[] nextG) {
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s.isEmpty() && arr[s.peek()]<=arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextG[i]=-1;
            }else{
                nextG[i]=arr[s.peek()];
            }
            s.push(i);
        }
        
    }

    public static void main(String[] args) {
        int[] arr = {6,8,0,1,3};
        int nextG[] = new int[arr.length];
        findNextGreaterElement(arr,nextG);
        for(int n:nextG){
            System.out.print(n+" ");
        }
    }
}
