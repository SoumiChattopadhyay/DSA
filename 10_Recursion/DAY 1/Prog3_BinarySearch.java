public class Prog3_BinarySearch {
    static int binarySearch(int[]ar,int si, int ei,int search){
        int mid=si+(ei-si)/2;
        //base condition 1
        if(si>ei){
            return -1;
        }
        //base condition 2
        if(search==ar[mid]){
            return mid;
        }else if(search<ar[mid]){
            return binarySearch(ar, si,mid-1, search);
        }else{
            return binarySearch(ar, mid+1,ei, search);
        }
    }
    public static void main(String[] args) {
        int ar[]={1, 2, 3, 4, 55, 66, 78};//sorted array
        System.out.println(binarySearch(ar,0,ar.length-1,55));//7+0/2=3
    }
}
