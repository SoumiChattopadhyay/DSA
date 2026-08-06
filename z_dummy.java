import java.util.ArrayList;

public class z_dummy {
    static void find_No_of_Islands(char[][] grid){
        // form adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                adjList.get()
            }
        }
    }
    public static void main(String[] args) {
        char[][]grid = {
            {'0','1','1','0'},
            {'0','1','1','0'},
            {'0','0','1','0'},
            {'0','0','0','0'},
            {'1','1','0','1'}
        };
    }
}
