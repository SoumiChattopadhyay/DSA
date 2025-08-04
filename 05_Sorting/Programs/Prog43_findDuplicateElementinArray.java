public class Prog43_findDuplicateElementinArray {
    public static int findDuplicate(int ar[]){
        int i=0;
        while(i<ar.length){
            int correctIdx=ar[i]-1;
            if(ar[correctIdx]!=ar[i]){
                int temp=ar[i];
                ar[i]=ar[correctIdx];
                ar[correctIdx]=temp;
            }else{//if el[correctIdx]==el[i]
                if(i!=correctIdx){
                    return ar[i];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int ar[]={3,1,3,4,2};
        System.out.println(findDuplicate(ar));
    }
}
