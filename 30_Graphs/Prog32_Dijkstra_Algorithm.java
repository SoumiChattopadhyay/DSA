import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
class Pair{
    int node;
    int distance;//distance of node from source node
    Pair(int node,int distance){
        this.node=node;
        this.distance=distance;
    }
}
public class Prog32_Dijkstra_Algorithm {//to find shortest distance from source node to each node
    public static int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<V;i++)adjList.add(new ArrayList<>());
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.distance-y.distance);        
        int[] dist = new int[V];
        for(int i=0;i<V;i++)dist[i]=Integer.MAX_VALUE;//or u can write 1e9(1 billion)
        
        dist[src]=0;
        pq.add(new Pair(src, 0));
        
        while(!pq.isEmpty()){
            int node=pq.peek().node;
            pq.remove();
            for(int[] arr:adjList.get(node)){
                int neighbor=arr[0];
                int edgeWt=arr[1];
                if(dist[node]!=Integer.MAX_VALUE && dist[node]+edgeWt<dist[neighbor]){
                    dist[neighbor]=dist[node]+edgeWt;
                    pq.add(new Pair(neighbor, dist[neighbor]));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][] edges = {
            {0, 1, 4},
            {0, 2, 4},
            {1, 2, 2},
            {2, 3, 3},
            {2, 5, 6},
            {2, 4, 1},
            {3, 5, 2},
            {4, 5, 3}
        };
        System.out.println(Arrays.toString(dijkstra(6,edges,0)));
    }
}
// If dist[] array is already there is separate pair class with distance property still needed?
// Yes so that the PriorityQueue can compare the Pair objects and store the one with shortest distance property at its top
// Algorithm:
/*  Create a priority queue that stores a collection of Pairs-(node,dist of node from src)
    Create a distance array that stores the respective distances of all nodes From the src vertex.
    Add the first pair in the queue (src,0) coz dist of src from itself is 0

  */

/*Comparator basics
    In Java, a comparator (x, y) -> x.dist - y.dist means:
    return negative → x comes before y
    return positive → x comes after y
    return 0 → equal order 

Meaning of each:
    (x, y) -> x.dist - y.dist
    Sorts in ascending order of dist
    Smaller dist comes first
    Example: [ (dist=2), (dist=5), (dist=10) ]
    Used for min-heaps or Dijkstra (to get smallest distance first)

    (x, y) -> y.dist - x.dist
    Sorts in descending order
    Larger dist comes first
    Example: [ (dist=10), (dist=5), (dist=2) ]
    Used for max-heaps*/