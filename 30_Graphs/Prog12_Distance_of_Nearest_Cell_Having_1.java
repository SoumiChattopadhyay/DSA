import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int row;
    int col;
    int step;

    Node(int r, int c, int s) {
        row = r;
        col = c;
        step = s;
    }
}

public class Prog12_Distance_of_Nearest_Cell_Having_1 {
    public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] distance = new int[n][m];

        distance = bfs(visited, distance, grid, n, m);
        return distance;
    }

    private int[][] bfs(boolean[][] visited, int[][] distance, int[][] grid, int n, int m) {
        Queue<Node> q = new LinkedList<>();
        // Initial configuration of Queue
        // n x m
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i, j, 0));
                    visited[i][j] = true;
                }
            }
        }
        // n x m x 4
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().step;
            distance[row][col] = step;
            q.remove();

            int[] drow = { 0, -1, 0, 1 };
            int[] dcol = { -1, 0, 1, 0 };
            for (int i = 0; i < 4; i++) {
                int nRow = row + drow[i];
                int nCol = col + dcol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !visited[nRow][nCol]) {
                    q.add(new Node(nRow, nCol, step + 1));
                    visited[nRow][nCol] = true;
                }

            }
        }
        return distance;
    }

    public static void main(String[] args) {
        Prog12_Distance_of_Nearest_Cell_Having_1 obj = new Prog12_Distance_of_Nearest_Cell_Having_1();
        int[][] grid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 0, 1 } };

        for (int[] arr : obj.updateMatrix(grid)) {
            System.out.println(Arrays.toString(arr));
        }
    }
    // Algorithm used:-
    // Apply BFS as that algorithm moves step by step or level by level not in depth
    // like DFS
    // You want all the 1s to traverse one step together so that you can always have
    // the minimum count with you
    // So we will apply BFS algorithm

    // Steps:-
    // Given grid matrix
    // Create visited matrix - we won't hamper given data(grid matrix) so we use
    // this but we can also only use the grid matrix
    // Create distance matrix - stores distance of nearest 1s from every cell
    // All the 1s in the grid matrix are the starting points where we will start BFS
    // from
    // In our example, we have 3 1s - so 3 starting points
    // Queue - store (row,col,step/dist)
    // First insert (row,col,step/dist=0) for the 3 sources - the 3 1s.
    // In the visited matrix, mark true for those 3 1s.
    // Remove the 1st 1 from the queue.
    // In the distance matrix, put step/dist value=0 for that 1, as it has nearest 1
    // as itself.
    // Take one step in all 4 directions from that 1.
    // If on taking one step, you get a 0 then for that 0 the nearest 1 is at
    // step/dist=1.
    // Mark 0 as visited and insert it's (row,col,step/dist) in the queue
    // Do this for all 4 directions
    // Now remove the 2nd 1 from the queue
    // In the distance matrix, put step/dist value=0 for that 1, as it has nearest 1
    // as itself.
    // Take one step in all 4 directions from that 1.
    // Do the same thing
    // But Ignore the 0s that are already visited
    // Do the same for the 3rd 1
    // Now remove the 0 from the queue
    // In the distance matrix, put step/dist value=1 for that 0, as it has nearest 1
    // at a dist=1
    // Take one step in all 4 directions from that 0.
    // If you get a 0 then for that 0 the nearest 1 is at step/dist=2.
    // Mark that 0 as visited and insert it's (row,col,step/dist) in the queue
    // Ignore the 0s that are already visited
    // Do this for all 4 directions
    // Take out the next 0 or 1 from the queue and do the same
}
