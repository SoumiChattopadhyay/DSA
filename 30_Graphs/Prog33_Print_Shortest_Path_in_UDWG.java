import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int node;
    int distance;// distance of node from source node

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Prog33_Print_Shortest_Path_in_UDWG {// Undirected Weighted Graph
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // form adjacency list
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            adjList.add(new ArrayList<>());// 1-based indexing so <=n
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(v);
            temp.add(w);
            adjList.get(u).add(temp);
            temp = new ArrayList<>();
            temp.add(u);
            temp.add(w);
            adjList.get(v).add(temp);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.distance-y.distance);
        int[] dist = new int[n + 1];
        for (int i = 0; i <= n; i++)
            dist[i] = (int)1e9;
        int[] parent = new int[n + 1];
        for (int i = 0; i <= n; i++)
            parent[i] = i;
        pq.add(new Pair(1, 0));
        dist[1] = 0;//1 is source vertex
        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            pq.remove();
            for(ArrayList<Integer> it:adjList.get(node)){
                int neighbor=it.get(0);
                int edgeWt=it.get(1);
                if(dist[node]+edgeWt<dist[neighbor]){
                    dist[neighbor]=dist[node]+edgeWt;
                    parent[neighbor]=node;
                    pq.add(new Pair(neighbor, dist[neighbor]));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        if(dist[n]==(int)1e9){
            ans.add(-1);
            return ans;
        }
        int node=n;//n is destination vertex
        while(parent[node]!=node){
            ans.add(node);
            node=parent[node];
        }
        ans.add(1);//manually add src node 1 as loop will not execute for it(parent[1]=1 so loop condition fails)
        Collections.reverse(ans);
        
        //for geeksforgeeks problem
        // Step 6: Add total weight at the start
        // ans.add(0, dist[n]);
        return ans;
    }

    public static void main(String[] args) {
        int[][] edges = {
            {1, 2, 2},
            {2, 5, 5},
            {2, 3, 4},
            {1, 4, 1},
            {4, 3, 3},
            {3, 5, 1}
        };
        List<Integer> ans = shortestPath(5, edges.length, edges);
        for(int it:ans){
            System.out.print(it+" ");
        }
    }
}
