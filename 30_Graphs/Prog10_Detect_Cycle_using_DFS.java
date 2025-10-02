import java.util.ArrayList;
public class Prog10_Detect_Cycle_using_DFS{
    public boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        boolean visited[] = new boolean[V+1];
        visited[1]=true;
        for(int i=1;i<=V;i++){
            if(!visited[i]){
                if(dfs(i,-1,visited,adj)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int node,int parent,boolean[] visited,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                if(dfs(neighbor, node, visited, adj)){//if its false you cannot return false you must continue the loop and go to other neighbors
                    return true;
                }
            }else if(neighbor!=parent){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Prog10_Detect_Cycle_using_DFS obj = new Prog10_Detect_Cycle_using_DFS();
        // int[][]edgeList = new int[][]{{1,2},{1,3},{2,5},{3,4},{3,6},{5,7},{6,7}};
        // int n=7;
        // Also works for graphs with multiple components
        int[][]edgeList = new int[][]{{1,2},{1,3},{2,4},{5,6},{7,8},{7,9},{8,9}};
        int n=9;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] edge:edgeList){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(adjList);
        System.out.println(obj.isCycle(n,adjList));
    }
}
