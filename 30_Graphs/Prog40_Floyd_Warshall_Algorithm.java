
// You are given an weighted directed graph, represented by an adjacency matrix, dist[][] of size n x n, 
// where dist[i][j] represents the weight of the edge from node i to node j. 
// If there is no direct edge, dist[i][j] is set to a large value (i.e., 108) to represent infinity.
// The graph may contain negative edge weights, but it does not contain any negative weight cycles.

// Your task is to find the shortest distance between every pair of nodes i and j in the graph.

// Note: Modify the distances for every pair in place.

import java.util.Arrays;

public class Prog40_Floyd_Warshall_Algorithm {
    public static void floydWarshall(int[][] dist) {
        int INF=(int)1e8;
        int V=dist.length;
        for(int via=0;via<V;via++){
            for(int i=0;i<V;i++){
                for(int j=0;j<V;j++){
                    if(dist[i][via]!=INF && dist[via][j]!=INF 
                    && dist[i][via]+dist[via][j]<dist[i][j])
                    {
                        dist[i][j]=dist[i][via]+dist[via][j];
                    }
                }
            }
        }
        // To check for negative cycle
        for(int i=0;i<V;i++){
                if(dist[i][i]<0){
                    System.out.println("Negative cycle present");
                }
            }
    }
    public static void main(String[] args) {
        int inf=(int)1e8;
        int[][] dist = {
            {0, 4, inf, 5, inf},
            {inf, 0, 1, inf, 6},
            {2, inf, 0, 3, inf},
            {inf, inf, 1, 0, 2},
            {1, inf, inf, 4, 0}
        };
        floydWarshall(dist);
        for(int[]arr:dist)
            System.out.println(Arrays.toString(arr));
        // Suppose in question -1 given instead of inf
        // then convert all -1 to inf by yourself
        // for(int i=0;i<V;i++){
        //     for(int j=0;j<V;j++){
        //         if(dist[i][j]==-1){
        //             dist[i][j]=(int)1e8;
        //         }
        //     }
        // }
        // And then after applying floyd warshall reconvert inf to -1 and return the array
    }
}
