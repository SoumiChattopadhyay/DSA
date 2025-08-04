public class Prog6_sorted_rotated_array_search {
    public static int search(int ar[],int start, int end, int target){
        int mid = start + (end-start)/2;
        if(start>end){
            return -1;
        }
        if(ar[mid]==target){
            return mid;
        }
        if(ar[mid]>=ar[start]){
            if(target>=ar[start] && target<ar[mid]){
               return search(ar,start,mid-1,target);
            }else{
               return search(ar,mid+1,end,target);
            }
        }
        else{
            if(target>ar[mid] && target<=ar[end]){
               return search(ar,mid+1,end,target);
            }else{
                return search(ar,start,mid-1,target);
            }
        }
    }
    public static void main(String[] args) {
        int ar[] = {4,5,6,7,0,1,2};//sorted and rotated array around pivot 2 since its at last
        int targetIdx = search(ar,0,ar.length-1,0);
        System.out.println(targetIdx);
    }
}
