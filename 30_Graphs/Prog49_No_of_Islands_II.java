// https://www.geeksforgeeks.org/problems/number-of-islands/1
import java.util.ArrayList;
import java.util.List;
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
            else{//when (size.get(ulp_v)<=size.get(ulp_u))
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
}
public class Prog49_No_of_Islands_II{
    public static boolean isValid(int adjr,int adjc, int n, int m){
        return adjr>=0 && adjr<n && adjc>=0 && adjc<m;
    }
    public static List<Integer> numOfIslands(int rows, int cols, int[][] queries) {
        DisjointSet ds = new DisjointSet(rows*cols);
        int[][] visited = new int[rows][cols];
        List<Integer> ans = new ArrayList<>();
        int cnt=0;
        for(int i=0;i<queries.length;i++){
            int row = queries[i][0];
            int col = queries[i][1];
            if(visited[row][col]==1){
                ans.add(cnt);
                continue;
            }
            cnt++;//consider (row,col) as an individual island
            visited[row][col]=1;
            int[] drow = {-1,0,+1,0};
            int[] dcol = {0,+1,0,-1};
            for(int idx=0;idx<4;idx++){
                int adjr = row+drow[idx];
                int adjc = col+dcol[idx];
                if(isValid(adjr,adjc,rows,cols)){
                    if(visited[adjr][adjc]==1){// if adj node of (row,col) is island 
                        int node = row * cols + col;
                        int adjnode = adjr * cols + adjc;
                        if(ds.findUPar(node)!=ds.findUPar(adjnode)){//and if adj node and node dont have same ultimate parents already then connect them
                            ds.union_by_Size(node, adjnode);
                            cnt--;//and reduce cnt as now (row,col) is no longer an individual island
                        }
                    }
                }
            }
            ans.add(cnt);
        }
        return ans;
    }
    public static void main(String[] args) {
        int n = 4;
        int m = 5;
        int[][] queries = {{1,1},{0,1},{3,3},{3,4}};
        System.out.println(numOfIslands(n,m,queries));
    }
}
