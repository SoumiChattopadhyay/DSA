import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
class Pair{
    int node;
    int edgeWt;
    Pair(int n,int eWt){
        node=n;
        edgeWt=eWt;
    }
}
public class Prog27_Shortest_Path_in_DAG{
    public static int[] shortestPath(int V, int E, int[][] edges) {
        //form the adjacency list
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)adjList.add(new ArrayList<>());
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            adjList.get(u).add(new Pair(v,wt));
        }
        //find topo sort, we just need the el.s to be present in topo order in the Stack
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,st,visited,adjList);
            }
        }
        //Relax edges: i)create dist array ii) pop node from stack iii)Try to go to its adjacent nodes 
        int[] dist = new int[V];
        for(int i=0;i<dist.length;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        dist[6]=0;//considering 6 as source vertex
        while(!st.isEmpty()){
            int node = st.pop();
            for(Pair pair:adjList.get(node)){
                int neighbor = pair.node;
                int wt = pair.edgeWt;
                // You should check whether dist[node] is Integer.MAX_VALUE before relaxing edges, otherwise dist[node] + wt might overflow.
                if(dist[node]!=Integer.MAX_VALUE && dist[node] + wt < dist[neighbor]){
                    dist[neighbor]=dist[node]+wt;
                }
            }
        }
        // Convert unreachable nodes' distances to -1 
        for (int i = 0; i < V; i++) {
            if (dist[i]==Integer.MAX_VALUE) {
                dist[i]=-1;
            }
        }
        return dist;
    }
    private static void dfs(int node,Stack<Integer> st,int[] visited,ArrayList<ArrayList<Pair>> adjList){
        visited[node]=1;
        for(Pair pair:adjList.get(node)){
            int neighbor=pair.node;
            if(visited[neighbor]==0){
                dfs(neighbor, st, visited, adjList);
            }
        }
        st.push(node);
    }
    public static void main(String[] args) {
        int edges[][] = {
            {6, 4, 2},
            {6, 5, 3},
            {5, 4, 1},
            {4, 0, 3},
            {4, 2, 1},
            {0, 1, 2},
            {1, 3, 1},
            {2, 3, 3}
        };
        System.out.println(Arrays.toString(shortestPath(7,edges.length,edges)));
    }
}