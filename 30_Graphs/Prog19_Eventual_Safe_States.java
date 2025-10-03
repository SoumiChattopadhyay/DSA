// There is a directed graph of n nodes with each node labeled from 0 to n - 1. 
// The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].
// A node is a terminal node if there are no outgoing edges. 
// A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).
// Return an array containing all the safe nodes of the graph. 
// The answer should be sorted in ascending order.
import java.util.ArrayList;
import java.util.List;
public class Prog19_Eventual_Safe_States {
    public static List<Integer> eventualSafeNodes(int[][] adjList) {
        int V=adjList.length;
        int visited[]=new int[V];
        int pathVisited[]=new int[V];
        int checkSafe[]=new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,pathVisited,checkSafe, adjList);
            }
        }
        List<Integer> safeNodes = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(checkSafe[i]==1){
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }
    private static boolean dfs(int node,int[] visited,int[] pathVisited, int[] checkSafe,int[][] adjList){
        visited[node]=1;
        pathVisited[node]=1;
        for(int neighbor:adjList[node]){
            //when the node has not been visited
            if(visited[neighbor]==0){
                if(dfs(neighbor,visited,pathVisited,checkSafe,adjList)==true){
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
        checkSafe[node]=1;
        pathVisited[node]=0;
        return false;
    }
    public static void main(String[] args) {
        // On the same path if you visit any node again, then cycle exists
        int[][] adjList = new int[][]{{1}, {2}, {3}, {4,5},{6},{6},{7},{},{1,9},{10},{8},{9}};//true
        List<Integer> ans = eventualSafeNodes(adjList);
        for(int item:ans){
            System.out.print(item+",");
        }
    }
}
