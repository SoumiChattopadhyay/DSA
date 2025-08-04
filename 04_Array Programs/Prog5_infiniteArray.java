public class Prog5_infiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 100;
        System.out.println(ans(arr,target));
}
    public static int ans(int ar[],int target){//finds correct start-end range, gives it to binarySearch funct and returns the ans that  binarySearch funct returns
        int start=0, end=1;//starting with box of size 1(having 1 el) and exponentially going to that big box which contains the target
        while(target>ar[end]){//increasing size of box exponentially
            int newStart=end+1;
            end=end+(end-start+1)*2;
            start=newStart;

            // Ensuring end does not exceed array bounds
            if (end >= ar.length) {
                end = ar.length - 1;
                break;
            }
        }
        return binarySearch(ar, target, start, end);//sending the correct start and end range
    }
    public static int binarySearch(int ar[],int target,int start,int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(target<ar[mid])
                end=mid-1;
            else if(target==ar[mid])
                return mid;
            else
                start=mid+1;
        }
        return -1;
    }
}
