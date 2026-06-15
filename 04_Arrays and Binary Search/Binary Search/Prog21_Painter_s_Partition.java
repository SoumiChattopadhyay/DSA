public class Prog21_Painter_s_Partition {//Painter's Partition (same solution as Book Allocation problem)
    static int allocate_Units(int[] arr, int k){
        int n=arr.length;
        if(k>n) return -1;
        int low=Integer.MIN_VALUE, high=0;
        for(int el:arr){
            low=Math.max(low,el);
            high+=el;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            int cntPainters = count_Allocated_Painters(arr, mid);
            if(cntPainters<=k){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    static int count_Allocated_Painters(int[] arr, int maxUnits){
        int painters=1,painterUnits=0;
        for(int i=0;i<arr.length;i++){
            if(painterUnits+arr[i]<=maxUnits){
                painterUnits+=arr[i];
            }
            else{
                painters++;
                painterUnits=arr[i];
            }
        }
        return painters;
    }
    public static void main(String[] args) {
        int[] units = {10,20,30,40};
        int painters=2;
        System.out.println(allocate_Units(units, painters));
    }
    
}
