// https://www.geeksforgeeks.org/problems/maximum-stone-removal-1662179442/1
// Given an 2D array of non-negative integers stones[][] where stones[i] = [xi, yi] represents the location of the ith stone on a 2D plane, the task is to return the maximum possible number of stones that you can remove.
// A stone can be removed if it shares either the same row or the same column as another stone that has not been removed.
// Note: Each coordinate point may have at most one stone.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
public class Prog51_Maximum_Stone_Removal {
    static int maxRemove(int[][] stones, int k) {
        // find the max no. of rows and max no. of cols of the grid from the stones array
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<k;i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }// No need to form the grid array,just find n & m. We will utilize the stones array only
        
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1); 
        HashSet<Integer> stoneNodes = new HashSet<>();
        for(int i=0;i<k;i++){
            int row = stones[i][0]; 
            int col = stones[i][1];
            ds.union_by_Size(row, col+maxRow+1);//connect colNode to rowNode
            stoneNodes.add(row);
            stoneNodes.add(col+maxRow+1);
        }
        int cnt=0;
        for(int it:stoneNodes){
            if(ds.findUPar(it)==it){
                // System.out.println(it);
                cnt++;
            }
        }
        return k-cnt;
    }
    // Method-2
    // We can also use Hashmaps instead of HashSet
    static int maxRemove2(int[][] stones, int k) {
        // find the max no. of rows and max no. of cols of the grid from the stones array
        int maxRow=0;
        int maxCol=0;
        for(int i=0;i<k;i++){
            maxRow = Math.max(maxRow,stones[i][0]);
            maxCol = Math.max(maxCol,stones[i][1]);
        }// No need to form the grid array,just find n & m. We will utilize the stones array only
        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1); 
        HashMap<Integer,Integer> stoneNodes = new HashMap<>();
        for(int i=0;i<k;i++){
            int row = stones[i][0]; 
            int col = stones[i][1];
            ds.union_by_Size(row, col+maxRow+1);
            stoneNodes.put(row,1);
            stoneNodes.put(col+maxRow+1,1);
        }
        int cnt=0;
        for(Map.Entry<Integer,Integer> it:stoneNodes.entrySet()){
            if(ds.findUPar(it.getKey())==it.getKey()){
                cnt++;
            }
        }
        return k-cnt;
    }
    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 2},{1,3}, {3, 1}, {3, 2}, {4, 3}};
        int k=6;//no. of stones
        System.out.println("Maximum stones that can be removed = "+maxRemove(stones, k));

        stones=new int[][]{{0,0},{1,1},{2,2},{2,3},{2,4},{3,2}};
        k=stones.length;
        System.out.println("Maximum stones that can be removed = "+maxRemove2(stones, k));
    }
    
}