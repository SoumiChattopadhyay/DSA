public class Prog5_Binary_Search {
    public int binarySearch(int ar[],int key){
        int start=0, end=ar.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            System.out.println(ar[mid]);
            if(key<ar[mid])
                end=mid-1;
            else if(key==ar[mid])
                return mid;
            else
                start=mid+1;
        }
        return -1;
    }
    public static void main(String[] args) {
        Prog5_Binary_Search obj = new Prog5_Binary_Search();
        int idx = obj.binarySearch(new int[]{2,3,4,5,6,7,8},8);
        if(idx==-1)
            System.out.println("Search NOT found");
        else
            System.out.println("Search found at index "+idx);
    }
}
// Cannot make a static reference to the non-static method binarySearch(int[], int) from the type Prog5_Binary_Search
