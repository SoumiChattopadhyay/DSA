import java.util.ArrayList;
public class Prog12_Linear_Search {
    public static void main(String[] args) {
       System.out.println(find(new int[]{2,4,5,6,78,8,12,44},8,0));
       System.out.println(find(new int[]{2,4,5,6,78,8,12,44},0,0));
       System.out.println(findIndex(new int[]{2,4,5,6,78,8,12,44},8,0));
       System.out.println(findIndex(new int[]{2,4,5,6,78,8,12,44},0,0));
       System.out.println(findMultipleIndex(new int[]{8,2,8,4,8,5,6,78,8,12,8,44,8},0,0));
       System.out.println(findMultipleIndex(new int[]{8,2,8,4,8,5,6,78,8,12,8,44,8},8,0));
       System.out.println(list2);
       findMultipleIndex2(new int[]{8,2,8,4,8,5,6,78,8,12,8,44,8},8,0);
       findMultipleIndex2(new int[]{8,2,8,4,8,5,6,78,8,12,8,44,8},0,0);
       System.out.println(list2);
       System.out.println(findMultipleIndex3(new int[]{8,2,8,4,8,5,6,78,8,12,8,44,8},8,0));
       System.out.println(findMultipleIndex3(new int[]{8,2,8,4,8,5,6,78,8,12,8,44,8},0,0));
    }

    //function that performs linear search and returns true or false
    public static boolean find(int[] arr,int target,int idx){
       if(idx==arr.length){
            return false;
        }
        return (arr[idx]==target) || find(arr, target, idx+1);
    }

    //function that performs linear search and returns index of target
    public static int findIndex(int[] arr,int target,int idx){
        if(idx==arr.length){
             return -1;
         }
         return (arr[idx]==target)?idx:findIndex(arr, target, idx+1);
    }

    //function that performs linear search from end and returns index of target
    static int findIndexLast(int[] arr, int target, int index) {
        if (index == -1) {
            return -1;
        }
        if (arr[index] == target) {
            return index;
        } else {
            return findIndexLast(arr, target, index - 1);
        }
    }

    //function that performs linear search and returns indexes of all occurrences of target
    static ArrayList<Integer> list = new ArrayList<>();
    public static ArrayList<Integer> findMultipleIndex(int[] arr,int target,int idx){
        if(idx==arr.length){
            return list;
        }
        if(arr[idx]==target){
            list.add(idx);
        }
        return findMultipleIndex(arr, target, idx+1);
    }

    //we also may not return anything as array list is a static variable
    static ArrayList<Integer> list2 = new ArrayList<>();
    public static void findMultipleIndex2(int[] arr,int target,int idx){
        if(idx==arr.length){
            return;
        }
        if(arr[idx]==target){
            list2.add(idx);
        }
        findMultipleIndex2(arr, target, idx+1);
    }

    public static ArrayList<Integer> findMultipleIndex3(int[] arr,int target,int idx){
        ArrayList<Integer> list3 = new ArrayList<>();
        if(idx==arr.length){
            return list3;
        }
        if(arr[idx]==target){
            list3.add(idx);
        }
        list3.addAll(findMultipleIndex3(arr, target, idx+1));
        return list3;
    }
 

}
