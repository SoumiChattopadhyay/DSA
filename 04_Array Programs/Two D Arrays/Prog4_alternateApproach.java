public class Prog4_alternateApproach {
    public static boolean staircaseSearch(int[][] matrix, int key) {
        int row = matrix.length - 1;
        int column = 0; 
        
        //Starting from bottom-left element - its pos=(matrix.length-1,0)
        while (row >= 0 && column <= matrix[0].length - 1) {
            if (matrix[row][column] == key) {
                System.out.println("Key found at position: (" + row + ", " + column + ")");
                return true;
            } else if (key < matrix[row][column]) {
                row--; // Move topward
            } else {
                column++; // Move rightward
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {//sorted 2D array already given in question
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        
        int key = 29;
        
        if (!staircaseSearch(matrix, key)) {
            System.out.println("Key not found");
        }
    }
}
