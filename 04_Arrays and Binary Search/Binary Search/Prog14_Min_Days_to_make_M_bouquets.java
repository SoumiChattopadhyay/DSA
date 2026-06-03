public class Prog14_Min_Days_to_make_M_bouquets {
    // Brute
    static int find_Min_Days(int[] arr, int m, int k){
        int n = arr.length;//no. of roses
        if((long)m * k > n)
            return -1;
        
        int minDay=Integer.MAX_VALUE, maxDay=Integer.MIN_VALUE;
        
        for(int i=0;i<n;i++) minDay=Math.min(minDay,arr[i]);//7
        for(int i=0;i<n;i++) maxDay=Math.max(maxDay,arr[i]);//13
        
        for(int day=minDay;day<=maxDay;day++){//[7->13]
            if(possible_Bouquets(arr, day, k)>=m){
                return day;
            }
        }
        return -1;
    }
    // Optimal (Binary Search)
    static int find_Min_Days2(int[] arr, int m, int k){
        int n=arr.length;
        if((long)m * k > n)
            return -1;
        int minDay=Integer.MAX_VALUE, maxDay=Integer.MIN_VALUE;
        for(int num : arr) minDay=Math.min(num,minDay);
        for(int num : arr) maxDay=Math.max(num,maxDay);
        
        int low=minDay, high=maxDay;
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(possible_Bouquets(arr, mid, k)>=m){
                ans=mid;//store ans
                high=mid-1;//search smaller no. of days
            }
            else{//if bouquets<m
                low=mid+1;//search larger no. of days(need more days)
            }
        }
        return ans;
    }
    static int possible_Bouquets(int[] arr, int day, int k){
        int cnt=0;
        int bouquets=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=day){
                cnt++;
            }
            else{
                bouquets+=(cnt/k);
                cnt=0;
            }
        }
        bouquets+=(cnt/k);
        return bouquets;
    }
    public static void main(String[] args) {
        int[] arr = {7,7,7,7,13,11,12,7};
        int m=2;//need to make m bouquets
        int k=3;//require k adjacent bloomed roses
        System.out.println(find_Min_Days(arr,m,k));
        System.out.println(find_Min_Days2(arr,m,k));

        arr = new int[]{1,10,3,10,2};
        m=3;
        k=2;
        System.out.println(find_Min_Days(arr, m, k));
        System.out.println(find_Min_Days2(arr, m, k));
    }
}
