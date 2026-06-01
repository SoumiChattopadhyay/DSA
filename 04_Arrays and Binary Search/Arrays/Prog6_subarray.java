public class Prog6_subarray {
    public static void main(String args[]){
        int ar[]={1,2,3,4,5};
        for(int i=0;i<ar.length;i++){
            for(int j=i;j<ar.length;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(ar[k]+" ");
                }
                System.out.println();
            }
        }
    }
}