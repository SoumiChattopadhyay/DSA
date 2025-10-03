// Detect a cycle in an undirected graph
// Given an undirected graph with V vertices labeled from 0 to V-1. The graph is represented using an adjacency 
// list where adj[i] lists all nodes connected to node. Determine if the graph contains any cycles.
// Note: The graph does not contain any self-edges (edges where a vertex is connected to itself).

// Logic: If neighbor of a node is already visited and it is not it's parent
// then it was visited through some other path,so cycle exists
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int curr;
    int parent;
    Pair(int curr,int parent){
        this.curr=curr;
        this.parent=parent;
    }
}
public class Prog9_Detect_Cycle_using_BFS{
    private boolean checkCycle(int src,int[] visited, ArrayList<ArrayList<Integer>> adjList){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,-1));
        visited[src]=1;
        while(!q.isEmpty()){
            int currNode = q.peek().curr;
            int parentNode = q.peek().parent;
            q.remove();
            for(int neighbor:adjList.get(currNode)){//get the currentNode's neighbour list
                if(visited[neighbor]==0){
                    q.add(new Pair(neighbor, currNode));
                    visited[neighbor]=1;
                }else if(parentNode!=neighbor){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int n, ArrayList<ArrayList<Integer>> adjList) {
        int visited[] = new int[n+1];
        for(int i=1;i<adjList.size();i++){
            if(visited[i]==0){
                if(checkCycle(i, visited, adjList)){
                return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Prog9_Detect_Cycle_using_BFS obj = new Prog9_Detect_Cycle_using_BFS();
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
