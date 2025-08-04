public class Prog46_findfirstMissingPositive {
    public static int findfirstMissingPositive(int[] ar) {
        int i=0;
        while(i<ar.length){
            int correctPos=ar[i]-1;
            if(ar[i]>0 && ar[i]<=ar.length && ar[i]!=ar[correctPos]){
                int temp=ar[i];
                ar[i]=ar[correctPos];
                ar[correctPos]=temp;
            }else{
                i++;
            }
        }
        for(int j=0;j<ar.length;j++){
            if(ar[j]!=j+1){
                return j+1;
            }
        }
        return ar.length+1;
    }
    public static void main(String[] args) {
        int ar[]={3,4,-1,1};
        System.out.println(findfirstMissingPositive(ar));
       
    }
}
