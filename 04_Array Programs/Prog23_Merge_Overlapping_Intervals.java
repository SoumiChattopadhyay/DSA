import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prog23_Merge_Overlapping_Intervals {
    // Brute Force
    // TC=O(2N), SC=O(N)
    static int[][] funct1(int[][] arr){
        int n=arr.length;
        // Sort by starting time(and if starting time is same then sorting happens by ending time)
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        
        List<int[]> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            int start=arr[i][0];
            int end=arr[i][1];
            // Skip if current interval is already contained in the last merged interval
            if(!ans.isEmpty() && end<=ans.get(ans.size()-1)[1]){
                continue;
            }
            // Start iterating over intervals after current interval
            for(int j=i+1;j<n;j++){
                if(arr[j][0]<=end){//overlapping interval found
                    end=Math.max(end,arr[j][1]);
                    //note: no need to check math.min for start because arr is already sorted by starting time
                }
                else{//not overlapping interval
                    break;//no need to check further intervals are overlapping or not(array is sorted)
                }
            }
            ans.add(new int[]{start,end});
        }

        return ans.toArray(new int[ans.size()][]);//scroll below for explanation
    }
    // Optimal Solution
    // TC=O(N),SC=O(N)
    static int[][] funct2(int[][] arr){
        int n=arr.length;
        // Sort by starting time(and if starting time is same then sorting happens by ending time)
        Arrays.sort(arr,(a,b)->a[0]-b[0]);
        
        List<int[]> ans = new ArrayList<>();
        
        for(int i=0;i<n;i++){
            // If current interval is not overlapping with the previous merged interval
            if(ans.isEmpty() || arr[i][0]>ans.get(ans.size()-1)[1]){
                ans.add(new int[]{arr[i][0],arr[i][1]});
            }
            // If current interval overlaps with the previous merged interval then update the previous merged interval 
            else{
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], arr[i][1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
    public static void main(String[] args) {
        int[][] arr = {{1, 3},{2, 6},{8, 9},{9, 11},{8, 10},{2, 4},{15, 18},{16, 17}};
        int[][] ans = funct1(arr);
        for(int[] ar:ans){
            System.out.print(Arrays.toString(ar)+",");
        }

        System.out.println();

        ans = funct2(arr);
        for(int[] ar:ans){
            System.out.print(Arrays.toString(ar)+",");
        }
    }
}

/*
return ans.toArray(new int[ans.size()][]);
This line converts a List<int[]> into a int[][] (2D array) before returning it.
Breaking it down:

ans — is a List<int[]>, i.e. a list of integer arrays
ans.size() — gets the number of intervals in the list
new int[ans.size()][] — creates a 2D array template with the correct number of rows, but the column size is left open ([]) since each interval can vary in size
.toArray(...) — converts the List into an array using the provided template to infer the correct type
 */
