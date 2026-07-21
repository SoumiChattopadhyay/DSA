import java.util.ArrayList;

public class Prog06_Remove_Duplicates_From_Sorted_Array {
    static ArrayList<Integer> removeDuplicates(int[] arr){
        int n=arr.length;
        int j=0;
        for(int i=1;i<n;i++){
            if(arr[i]!=arr[j]){
                j++;
                arr[j]=arr[i];
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int k=0;k<=j;k++){
            ans.add(arr[k]);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 3, 4, 4};
        System.out.println(removeDuplicates(arr));
    }
}
/*
Idea :
    j points to the last unique element.
    i scans the array.
    If arr[i] is different from arr[j], it is a new unique element.
    Increment j.
    Copy arr[i] to arr[j].

Dry Run
Input: [1, 1, 2, 2, 3, 4, 4]
j	i	            Action	                        Array
0	1	    Same, skip	                        1 1 2 2 3 4 4
0	2	    Different → j++, arr[j]=2	        1 2 2 2 3 4 4
1	3	    Same, skip	                        1 2 2 2 3 4 4
1	4	    Different → j++, arr[j]=3	        1 2 3 2 3 4 4
2	5	    Different → j++, arr[j]=4	        1 2 3 4 3 4 4
3	6	    Same, skip	                        1 2 3 4 3 4 4 

*/