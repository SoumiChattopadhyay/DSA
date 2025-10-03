import java.util.ArrayList;

public class Prog18_Cycle_Detection_in_Directed_Graph{
    // TC=O(V+E) as it is a directed graph so total degree = E(no. of edges)
    // SC=O(4N)=O(N)
    public static boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjList.add(new ArrayList<>());
        }               
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            adjList.get(u).add(v);//directed graph so only add v in u
        }
        int visited[]=new int[V];
        int pathVisited[]=new int[V];
        //checking for components
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                if(dfs(i,visited, pathVisited, adjList, V)){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean dfs(int node,int[] visited, int[] pathVisited, ArrayList<ArrayList<Integer>> adjList,int V){
        visited[node]=1;
        pathVisited[node]=1;
        for(int neighbor:adjList.get(node)){
            //when the node has not been visited
            if(visited[neighbor]==0){
                if(dfs(neighbor,visited, pathVisited, adjList, V)){
                    return true;
                }
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if(pathVisited[neighbor]==1){//pathVisited 1 means we are in the same path
                return true;
            }
            //if neighbor is already visited and it is in the same path
            //then that path is a cycle
        }
        pathVisited[node]=0;
        return false;
    }
    public static void main(String[] args) {
        // On the same path if you visit any node again, then cycle exists
        int[][] edgeList = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 3}};//true
        int V=4;
        System.out.println(isCyclic(V, edgeList));
        edgeList = new int[][]{{0, 1}, {1, 2}};//false
        V = 3;
        System.out.println(isCyclic(V, edgeList));
    }
}

