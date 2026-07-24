// https://leetcode.com/problems/making-a-large-island/description/
// You are given a square binary grid. A grid is considered binary if every value in the grid is either 1 or 0. You can change at most one cell in the grid from 0 to 1. You need to find the largest group of connected  1's. Two cells are said to be connected if both are adjacent(top, bottom, left, right) to each other and both have the same value.
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){//taking i till n works for both 0-based index graph & 1-based index graph
                size.add(1);
                parent.add(i);//You need to use .add() to fill the lists first..set() only works on existing indices. 
            }
        }
        public int findUPar(int node){
            if(node==parent.get(node)){
                return node;
            }
            //Path Compression
            int ulp_node=findUPar(parent.get(node));
            parent.set(node,ulp_node);
            return ulp_node;
        }
        public void union_by_Size(int u, int v){
            int ulp_u=findUPar(u);
            int ulp_v=findUPar(v);
            if(ulp_u==ulp_v){// already in same component. Nothing to do
                return;
            }
            if(size.get(ulp_v)>size.get(ulp_u)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            }
            else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
}
public class Prog50_Largest_Island{
    private static boolean isValid(int adjrow, int adjcol, int n){
        return adjrow>=0 && adjrow<n && adjcol>=0 && adjcol<n;
    }
    // Total TC = O(n^2 * 4 * 4α) + O(n^2 * 4 * 4α) + O(n^2 * 4α) or O(4α) ≈ O(n^2)
    public static int maxConnection(int grid[][]) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int cnt=0;
        // step-1 : connecting components (traverse the grid and connect all 1's with adjacent 1's)
        // TC:O(n^2 * 4 * 4α)
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==0){
                    cnt++;
                    continue;
                }
                int[] drow = {0,-1,0,+1};
                int[] dcol = {-1,0,+1,0};
                for(int idx=0;idx<4;idx++){
                    int adjRow = row + drow[idx];
                    int adjCol = col + dcol[idx];
                    if(isValid(adjRow,adjCol,n) && grid[adjRow][adjCol]==1){
                        int node = row * n + col;
                        int adjNode = adjRow * n + adjCol;
                        ds.union_by_Size(node, adjNode);
                    }
                }
            }
        }
        // step-2 : Use Brute Force and try converting every 0 in the grid to 1 once at a time. No need to actually convert it just consider it converted.
        // TC: O(n^2 * 4 * 4α)
        int max=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    continue;
                }     
                int[] drow = {0,-1,0,+1};
                int[] dcol = {-1,0,+1,0};
                HashSet<Integer> components = new HashSet<>();
                for(int idx=0;idx<4;idx++){
                    int adjRow = row + drow[idx];
                    int adjCol = col + dcol[idx];
                    if(isValid(adjRow,adjCol,n) && grid[adjRow][adjCol]==1){
                        int adjNode = adjRow * n + adjCol;
                        components.add(ds.findUPar(adjNode));
                    }
                }
                int sizeTotal=0;
                for(Integer ulp:components){
                    sizeTotal += ds.size.get(ulp);
                }
                max = Math.max(max,sizeTotal+1);//+1 for the 0 converted to 1
            }
        }
        // If grid contains all 1's
        // But we need to find the ultimate_parent
        // TC: O(n^2 * 4α)
        // for(int cellNo=0;cellNo<n*n;cellNo++){
        //     max = Math.max(max,ds.size.get(ds.findUPar(cellNo)));
        // }
        // return max;
        // Alternate way
        // TC: O(4α)
        if(cnt==0){//there were NO zeros in the entire grid, the grid is all 1s
            return ds.size.get(ds.findUPar(0));
        }
        return max;
    }
    public static void main(String[] args) {
        int[][] binGrid = {
             {1, 0, 1},
             {1, 0, 1},
             {1, 0, 1}
        };
        System.out.println("Largest group has "+maxConnection(binGrid)+" islands");
    }
}
