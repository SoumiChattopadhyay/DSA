public class Prog11_array_sorted_or_not {
    public static void main(String[] args) {
        System.out.println(checkSorted(new int[]{2,4,5,6,7,9},0));
        System.out.println(checkSorted(new int[]{6,7,9,2,4,5},0));
    }
    public static boolean checkSorted(int[] arr,int index){
        if(index==arr.length-1){
            return true;
        }
        return (arr[index]<arr[index+1]) && checkSorted(arr,index+1);
    }
}