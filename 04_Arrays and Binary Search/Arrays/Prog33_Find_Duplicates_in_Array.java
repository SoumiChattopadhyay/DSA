/*
Duplicates in a Limited Range Array
Given an array arr[] of size n, containing elements from the range 1 to n, and each element 
appears at most twice, return an array of all the integers that appears twice.
Note: You can return the elements in any order but the driver code will print them in sorted order. */
import java.util.ArrayList;
import java.util.Arrays;

public class Prog33_Find_Duplicates_in_Array {
    static ArrayList<Integer> findDuplicates(int[] arr) {
        int i=0, n=arr.length;
        while(i<n){
            int correctIdx=arr[i]-1;
            if(arr[i]!=arr[correctIdx]){
                int temp=arr[i];
                arr[i]=arr[correctIdx];
                arr[correctIdx]=temp;
            }else{
                i++;
            }
        }
        ArrayList<Integer> duplicates = new ArrayList<>();
        for(int j=0;j<n;j++){
            if(arr[j]-1!=j){
                duplicates.add(arr[j]);
            }
        }
        System.out.println(Arrays.toString(arr));//[1, 2, 3, 2, 3]
        return duplicates;
    }
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 2, 3};
        System.out.println(findDuplicates(arr));
    }
}

/*
Logic(Cyclic Sort algorithm is used here) -
Since we are given elements from 1 to n, correct position of an el is el-1
Ex: Correct position of el 4 is idx 3, of el 5 is idx 4 and so on...
The array isn't sorted. First while loop puts all els in their correct positions except the 
duplicates which occupy the end of the array.
In 2nd for loop we traverse the entire array and add those elements to the list whose position is 
incorrect i.e. the duplicate elements
Time Complexity
O(n)
Space Complexity
O(1) (excluding the output list)

Algorithm:
Suppose we start the loop with i
So arr[i] into consideration
Its correctIdx should be arr[i]-1
So check if arr[i]== the el at correctIdx (arr[correctIdx]) or not
If yes then just increase i and go to next el
If no then swap those els so that arr[i] goes back to its correct position
*/