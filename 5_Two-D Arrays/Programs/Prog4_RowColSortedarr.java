import java.util.Arrays;
public class Prog4_RowColSortedarr{
    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };

        System.out.println(Arrays.toString(search(arr, 49)));
    }

    static int[] search(int[][] arr, int target) {
        int r = 0;
        int c = arr[0].length - 1;

        while (r < arr.length && c >= 0) {//TC=O(n)  {O(2n)=O(n)}//in worst case n operations for going behind and n operations for going down 
            if (arr[r][c] == target) {
                return new int[]{r, c};
            }
            if (arr[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return new int[]{-1, -1};
    }
}
