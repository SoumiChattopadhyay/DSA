import java.util.Arrays;
public class Prog15_flip_image {
    public static int[][] flipImage(int[][] image){
        for(int[] row:image){
            //reverse the array - row
            for(int j=0;j<(row.length+1)/2;j++){ //or <=(row.length-1)/2
                int temp=row[j]^1;
                row[j]=row[row.length-1-j]^1;
                row[row.length-1-j]=temp;
            }
        }
        return image;
    } 
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(flipImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}})));
        System.out.println(Arrays.deepToString(flipImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}})));
    }
}
// For an odd series:
// The middle element's position is found by calculating (n + 1) / 2
// For an even series:
// The middle elements are two elements, not just one. Their positions are found by n / 2 and (n / 2) + 1 where n is the total number of elements.
