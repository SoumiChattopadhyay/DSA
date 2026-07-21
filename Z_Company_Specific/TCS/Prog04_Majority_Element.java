public class Prog04_Majority_Element {
    // Optimal
    // Moore's Voting Algorithm
    // TC=O(N), SC=O(1)
    static int findMajorityEl(int[] arr){
        int n=arr.length;
        
        int el=arr[0];
        int cnt=0;
        
        for(int i=0;i<n;i++){
            if(cnt==0){
                el=arr[i];
                cnt++;
            }
            else if(el==arr[i]) cnt++;
            else cnt--;
        }
        
        cnt=0;
        for(int i=0;i<n;i++){
            if(arr[i]==el){
                cnt++;
            }
        }
        if(cnt>(n/2)) return el;
        else return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(findMajorityEl(arr));
    }
}
