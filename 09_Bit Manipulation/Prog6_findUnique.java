public class Prog6_findUnique {
    public static int findUnique(int ar[]){
        int bitcount[]=new int[32];
        for(int i=0;i<ar.length;i++){
            if(((ar[i]>>i)&1)==1){
                bitcount[i]++;
            }
        }
        for(int i=0;i<bitcount.length;i++){
            bitcount[i]=bitcount[i]%3;
            if(bitcount[i]!=0){
                
            }
        }
        return -1;
        // Way 2
        // for(int ele:ar){
        //     for(int i=0;i<32;i++){
        //         if(((ele>>i)&1)==1){
        //             bitcount[i]++;
        //         }
        //     }
        // }
        // for(int i=0;i<bitcount.length;i++){
        //     bitcount[i]=bitcount[i]%3;
        // }
        // int result=0;
        // for(int i=0;i<bitcount.length;i++){
        //     if(bitcount[i]==1){
        //         result=result|(1<<i);
        //     }
        // }        
    }
    public static void main(String[] args) {
        System.out.println(findUnique(new int[]{2,2,3,2,7,7,8,7,8,8}));
    }
}
