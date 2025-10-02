import java.util.ArrayList;

public class Prog4_No_of_Provinces {
    //TC=O(N)+O(V+2E), SC=O(N)+O(N)
    public int findCircleNum(int[][] adjMatrix) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int N = adjMatrix.length;//no. of vertices
        for(int i=0;i<N;i++){
            adj.add(new ArrayList<>());
        }
        //form the adjacency list from the given adjacency matrix
        for(int i=0;i<adjMatrix.length;i++){
            for(int j=0;j<adjMatrix[i].length;j++){
                if(adjMatrix[i][j]==1 && i!=j){//avoid self-loops
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                } 
            }
        }
        int[] visited = new int[N+1];

        int count=0;
        for(int i=0;i<adj.size();i++){// Even if the DFS function is not called from this loop directly for all N nodes due to condition fail, but the loop is still running N times. So TC for this loop is O(N)
            if(visited[i]==0){//O(1)
                count++;
                dfs(i,visited,adj);
            }
        }
        return count;
    }
    public void dfs(int node,int[] visited,ArrayList<ArrayList<Integer>>adj){
        visited[node]=1;//O(1)
            for(int neighbor:adj.get(node)){
                if(visited[neighbor]!=1){//O(1)
                    dfs(neighbor, visited, adj);
                }
            }
    }
    public static void main(String[] args) {
        int[][] adjMatrix = {
        // 1 2 3 4 5 6 7 8   (columns)
        {0,1,1,0,0,0,0,0}, // 1
        {1,0,1,0,0,0,0,0}, // 2
        {1,1,0,0,0,0,0,0}, // 3
        {0,0,0,0,1,1,0,0}, // 4
        {0,0,0,1,0,1,0,0}, // 5
        {0,0,0,1,1,0,0,0}, // 6
        {0,0,0,0,0,0,0,1}, // 7
        {0,0,0,0,0,0,1,0}  // 8
        };
        Prog4_No_of_Provinces obj = new Prog4_No_of_Provinces();
        System.out.println( obj.findCircleNum(adjMatrix));
    }
}
// What matters is the no. of operations 
//condition check operation takes O(1) * N times outer loop runs so O(1)*N= O(N)
//marking visit operation O(1) * N times dfs() called so O(1)*N = O(N)
//condition check operation takes O(1) * 2E times inner loop runs so O(1)*2E= O(2E)
//TC = O(N) + O(N) + O(2E) = O(N+E)


// How to know if 0-based idx given or 1-based?
// if the input is given as a 2D array like int[][] isConnected, its valid indices are 0 … n-1. That’s the first hint.
// In the LeetCode Example, Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Here, isConnected[0][1] = 1 means city 0 is connected to city 1.

// edge.length gives no. of edges whereas adj.size() gives no. of nodes   

