public class Prog41_findMissingNumber {
    public static int missingNumber(int[] ar) {
        int i=0;
        while(i<ar.length){
            int correctPos=ar[i];
            if(ar[i]<ar.length && ar[i]!=ar[correctPos]){
                int temp=ar[i];
                ar[i]=ar[correctPos];
                ar[correctPos]=temp;
            }else{
                i++;
            }
        }
        for(int idx=0;idx<ar.length;idx++){
            if(ar[idx]!=idx){
                return idx; 
            }
        }
        // case 2: If the array given is [3,2,1,0] then we get [0,1,2,3] so we simply return 4
        return ar.length;
    }
    public static void main(String[] args) {
        int ar[]={4,0,2,1};
        System.out.println( missingNumber(ar));
       
    }
}