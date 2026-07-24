/*
Second most repeated string in a sequence
Given a sequence of strings arr[], find and return the second highest frequency (count of occurrences) among all strings in the array.

Note:

If all strings have the same frequency, return -1.
If there is only one unique string in the array, return -1.
If the array is empty, return -1.
Examples:

Input: arr[] = ["aaa", "bbb", "ccc", "bbb", "aaa", "aaa"]
Output: 2
Explanation: "bbb" is the second most occurring string with frequency 2. So the answer for this test case is 2.
*/

import java.util.HashMap;

public class Prog32_Second_Most_Repeated_Character_in_A_Sequence {
    static int secFrequent(String[] arr) {
        if(arr.length==0)//If the array is empty, return -1
            return -1;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
        }
        if(map.size()==1)//If there is only one unique string in the array, return -1
            return -1;
        int first=0,second=0;
        for(int count:map.values()){
            if(count>first){
                second=first;
                first=count;
            }else if(count>second && count<first){
                second=count;
            }
        }
        return second==0?-1:second;//If all strings have the same frequency, return -1
    }
    public static void main(String[] args) {
        String arr[] = {"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
        System.out.println(secFrequent(arr));
    }
}
