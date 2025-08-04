//TC :O(n)
//SC: O(n+n)=O(n)
public class Prog25_is_array_Sorted{
    public static boolean isSorted(int ar[], int i){
        if(i==ar.length-1)
            return true;
        else{
            if(ar[i]>ar[i+1])
                return false;
            return isSorted(ar,i+1);
        }
    }
    public static void main(String[] args) {
        int ar[]={1,2,6,3,4};
        System.out.println(isSorted(ar,0));
    }
}