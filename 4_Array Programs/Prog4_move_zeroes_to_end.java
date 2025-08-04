public class Prog4_move_zeroes_to_end {
    public int[] moveZeroestoEnd(int ar[]){
        int j=0;
        for(int i=0;i<ar.length;i++){
            if (ar[i] != 0) {
                int temp = ar[i];  // Swap non-zero element to the left
                ar[i] = ar[j];
                ar[j] = temp;
                j++;  // Move j forward
            }
        }
        return ar;
    }
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
