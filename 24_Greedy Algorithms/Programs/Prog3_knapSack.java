import java.util.*;
public class Prog3_knapSack{
public static void main(String[] args) {
    int weight[]={20,10,30};
    int value[]={100,60,120};
    int capacity=50;
    double maxVal=0;
    int n=weight.length;
    double arr[][]=new double[weight.length][2];
    for(int i=0;i<n;i++){
        arr[i][0]=i;
        arr[i][1]=value[i]/(double)weight[i];
    }
    Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));
    for(int i=n-1;i>=0;i--){
        int idx = (int)arr[i][0];
        if(capacity>=weight[idx]){
            maxVal+=arr[i][1]*weight[idx];
            capacity-=weight[idx];
        }
        else{
            maxVal+=arr[i][1]*capacity;
            capacity=0;
        }
    }
    System.out.println("Max val="+maxVal);
}
}
/*We have been given two arrays: weights and values, containing the weights of items and their respective prices. 
We need to find the ratio of value to weight in a sorted fashion. 
To do this, we take a 2D array where the first element is the index and the second element is the ratio. 
Since the ratio can be a decimal, we use a double-type 2D array.
Next, we sort this array using a comparator because we want to sort based on the ratio, not the index. 
As a result, the array is now arranged in ascending order based on the ratio. 
Now, we need to maximize the total value while minimizing the weight, meaning we should prioritize the highest ratio first.
We start a loop from n - 1 to 0 and check if the knapsack's capacity is greater than or equal to the weight of the item at the given index. 
If it is, we add the full value of the item (ratio × weight) and subtract its weight from the capacity. 
Otherwise, if the capacity is less than the item's weight, we take a fraction of it (ratio × remaining capacity), and the capacity is set to zero.
Finally, we print the maximum value that can be obtained within the given capacity.
The sorting algorithm used with the comparator is typically a mix of Insertion Sort, Merge Sort, or Quick Sort, which takes O(n log n) time. 
The two loops (one for storing ratios and one for filling the knapsack) each take O(n) time. Since sorting dominates, the overall time complexity is O(n log n)
*/