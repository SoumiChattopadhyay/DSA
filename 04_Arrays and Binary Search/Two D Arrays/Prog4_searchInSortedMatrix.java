public class Prog4_searchInSortedMatrix {
    public static boolean staircaseSearch(int[][] matrix, int key) {
        int row = 0;
        int column = matrix[0].length-1; 
        
        //Starting from top-right element - its pos=(0,matrix.length-1)
        while (row <= matrix.length - 1 && column >= 0) {
            if (matrix[row][column] == key) {
                System.out.println("Key found at position: (" + row + ", " + column + ")");
                return true;
            } else if (key < matrix[row][column]) {
                column--; // Move leftward
            } else {
                row++; // Move downward
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
        System.out.println(matrix.length); // 4 (4 rows)
        int key = 33;
    
        if (!staircaseSearch(matrix, key)) {
            System.out.println("Key not found");
        }
    }
}
