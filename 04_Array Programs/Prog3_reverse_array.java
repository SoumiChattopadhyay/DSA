public class Prog3_reverse_array {
    public int[] reverseArray(int ar[],int start,int end){
        while(start<end){//dont know how many times the loop will run so use while loop
            int temp=ar[start];
            ar[start]=ar[end];
            ar[end]=temp;
            start++;
            end--;
        }
        return ar;
    }
    public void printArray(int ar[]){
        for(int i=0;i<ar.length;i++){
            System.out.print(ar[i]+" ");
        }
    }
    public static void main(String args[]){
        int ar[]={1,2,3,4,5};
        Prog3_reverse_array obj = new Prog3_reverse_array();
        int arr[]=obj.reverseArray(ar,0,ar.length-1);
        obj.printArray(arr);
    }
}
