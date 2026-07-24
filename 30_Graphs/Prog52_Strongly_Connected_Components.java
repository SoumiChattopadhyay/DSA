// Given an adjacency list of Directed Graph, Find the number of strongly connected components in the graph.

// Recommendation:Try changing Stack st = new Stack<>(); to Deque st = new ArrayDeque<>(); 
// and resubmitting. This is a common performance improvement in Java for stack operations.
import java.util.ArrayList;
import java.util.Stack;

public class Prog52_Strongly_Connected_Components {
    public static int kosaraju(int n, ArrayList<ArrayList<Integer>> adjList) {
        
        // step-1: sort edges acc. to finishing time 
        // do dfs and store in stack
        // SC = O(2*V) {one for visited and one for stack}
        int[]visited = new int[n];
        Stack<Integer> st = new Stack<>();//can also use Deque
        // TC = O(V+E) {for dfs}
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfs1(i,visited,adjList,st);
            }
        }

        // step-2:Reverse the graph (create transpose)
        // SC = O(V+E)
        ArrayList<ArrayList<Integer>> adjListT = new ArrayList<>();
        // TC = O(V+E) {for transposing the graph}
        for(int i=0;i<n;i++){
            adjListT.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            visited[i]=0;//to reuse it later
            for(Integer it:adjList.get(i)){
                adjListT.get(it).add(i);
            }
        }

        // step-3: Do a dfs on the reversed graph to identify and print components
        int sccCount=0;
        // TC = O(V+E) {again for dfs}
        while(!st.isEmpty()){
            int node = st.pop();
            if(visited[node]==0){
                sccCount++;
                System.out.print("SCC " + sccCount + ": ");
                dfs3(node, visited, adjListT);
                System.out.println();// New line after printing the component
            }
        }
        return sccCount;
    }//So total TC = 3*(O(V+E)), total SC = O(2*V) + O(V+E)
    private static void dfs1(int node,int[] visited,ArrayList<ArrayList<Integer>> adjList,Stack<Integer> st){
        visited[node]=1;
        for(int neighbor:adjList.get(node)){
            if(visited[neighbor]==0){
                dfs1(neighbor, visited, adjList,st);
            }
        }
        st.push(node);
    }
    private static void dfs3(int node,int[] visited,ArrayList<ArrayList<Integer>> adjListT){
        System.out.print(node + " "); // Print the node as part of the current SCC
        visited[node]=1;
        for(int neighbor:adjListT.get(node)){
            if(visited[neighbor]==0){
                dfs3(neighbor, visited, adjListT);
            }
        }
    }
    public static void main(String[] args) {
        int[][] edges = {
            {0,1},
            {1,2},
            {2,0},
            {2,3},
            {3,4},
            {4,5},
            {4,7},
            {5,6},
            {6,4},
            {6,7}
        };
        int n=8;// Number of vertices (0 to 7)
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        int m=edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adjList.get(u).add(v);
        }
        System.out.println("No. of SCCs = "+kosaraju(n,adjList));
    }
}
