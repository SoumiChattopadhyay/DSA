import java.util.Arrays;

public class Prog03_firstandLastOccurenceofTarget {
    public static int[] searchRange(int[] nums, int target) {
        int ans[]={-1,-1};
        ans[0]=search(nums,target,true);
        if(ans[0]!=-1)
            ans[1]=search(nums,target,false);
        return ans;
    }
    public static int search(int[] nums,int target,boolean findstartIndex){
        int ans=-1;
        int start=0, end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
		    printArray(start,end,nums);
            if(target<nums[mid])
                end=mid-1;
            else if(target==nums[mid]){
                ans=mid;//found and stored
                if(findstartIndex){//what if there are more targets before this
                    end=mid-1;
                }else{//what if there are more targets after this
                    start=mid+1;
                }
            } 
            else
                start=mid+1;
        }
        return ans;
    }
public static void main(String[] args) {
    int[] arr = {5,7,7,8,8,10,8,7,8};
    int target = 8;
    int ar[]=Prog03_firstandLastOccurenceofTarget.searchRange(arr, target);
    System.out.println(Arrays.toString(ar));
}
  static void printArray(int start, int end, int[] arr){
		for(int i=start;i<=end;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
   }
}
