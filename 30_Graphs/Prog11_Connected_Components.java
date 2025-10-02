// Connected Components
// Given a undirected Graph consisting of V vertices numbered from 0 to V-1 and E edges. 
// The ith edge is represented by [ai,bi], denoting a edge between vertex ai and bi. We say two vertices 
// u and v belong to a same component if there is a path from u to v or v to u. Find the number of 
// connected components in the graph.
// A connected component is a subgraph of a graph in which there exists a path between any two vertices, 
// and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

// dfs or bfs traversal is needed for counting the connected components
import java.util.ArrayList;

public class Prog11_Connected_Components {
    // Function to count connected components
    public int countComponents(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        int count = 0;

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, adj);
                count++; // one full DFS means one component
            }
        }
        return count;
    }

    // DFS traversal
    private void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> adj) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, adj);
            }
        }
    }

    // Driver code
    public static void main(String[] args) {
        Prog11_Connected_Components obj = new Prog11_Connected_Components();

        // Example: Graph with 9 vertices (0 to 8)
        int V = 9;
        int[][] edgeList = new int[][]{
            {0,1}, {0,2}, {1,3},      // component 1
            {4,5},                     // component 2
            {6,7}, {6,8}, {7,8}        // component 3
        };

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edgeList) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        // Output number of connected components
        System.out.println("Adjacency List: " + adjList);
        System.out.println("Connected Components: " + obj.countComponents(V, adjList));
    }
}
