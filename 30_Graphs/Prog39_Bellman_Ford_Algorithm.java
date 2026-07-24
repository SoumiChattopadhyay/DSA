// https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/0
// Given an weighted graph with V vertices numbered from 0 to V-1 and E edges, represented by a 2d array edges[][], where edges[i] = [u, v, w] represents a direct edge from node u to v having w edge weight. You are also given a source vertex src.
// Your task is to compute the shortest distances from the source to all other vertices. If a vertex is unreachable from the source, its distance should be marked as 108. Additionally, if the graph contains a negative weight cycle, return [-1] to indicate that shortest paths cannot be reliably computed.

import java.util.Arrays;
//To find Shortest distance from src node to all nodes
public class Prog39_Bellman_Ford_Algorithm {
    public static int[] bellmanFord(int V, int[][] edges, int src) {
        
        int[] dist=new int[V];
        for(int i=0;i<V;i++)dist[i]=(int)1e8;
        dist[src]=0;
       
        for(int i=0;i<V-1;i++){
            for(int[] edge:edges){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                
                if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                }
            }
        }
        //Nth relaxation to check negative cycle
        for(int[]edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            
            if(dist[u]!=(int)1e8 && dist[u]+wt<dist[v]){
                return new int[]{-1};
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int[][]edges=new int[][]{{1, 3, 2}, {4, 3, -1}, {2, 4, 1}, {1, 2, 1}, {0, 1, 5}};
        System.out.println(Arrays.toString(bellmanFord(5, edges, 0)));
        edges= new int[][]{{0, 1, 4}, {1, 2, -6}, {2, 3, 5}, {3, 1, -2}};
        System.out.println(Arrays.toString(bellmanFord(4, edges, 0)));
    }
}
