public class Prog4_move_zeroes_to_end {
    public int[] moveZeroestoEnd(int ar[]){
        int j=0;//advances and stops at 0 (due to if condition) then when i reaches non-zero el then non-zero el moved to zero el position
        for(int i=0;i<ar.length;i++){
            if (ar[i] != 0) {
                int temp = ar[i];  // Swap non-zero element to the left
                ar[i] = ar[j];
                ar[j] = temp;
                j++;  // Move j forward
            }
        }
        return ar;
    }//Whenever i encounters a non-zero el, we advance j and swap jth el with ith el
    // means whenever i encounters zero j is not incremented further it freezes there until i reaches a non-zero el and then swapping happens and j is again incremented to j+1(not i+1)
    public void printArray(int ar[]){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void main(String args[]){
        int ar[]={1,2,0,3,0,0,4,0};
        Prog4_move_zeroes_to_end obj = new Prog4_move_zeroes_to_end();
        int arr[]=obj.moveZeroestoEnd(ar);
        obj.printArray(arr);
    }
}
