// You are given an adjacency list, adj of Undirected Graph having unit weight of the edges, 
// find the shortest path from src to all the vertex and if it is unreachable to reach any 
// vertex, then return -1 for that vertex.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
public class Prog28_Shortest_Path_in_Undirected_Graph{
    public static int[] shortestPath(int src,ArrayList<ArrayList<Integer>> adjList) {
        int dist[]=new int[adjList.size()];
        for(int i=0;i<adjList.size();i++)dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int neighbor:adjList.get(node)){
                if(dist[node]!=Integer.MAX_VALUE && dist[node]+1<dist[neighbor]){
                    dist[neighbor]=dist[node]+1;
                    q.add(neighbor);
                }
            }
        }
        for(int i=0;i<adjList.size();i++){
            if(dist[i]==Integer.MAX_VALUE)
                dist[i]=-1;
        }
        return dist;
    }
    public static void main(String[] args) {
        int edges[][] = {{1, 3}, {0, 2}, {1, 6}, {0, 4}, {3, 5}, {4, 6}, {2, 5, 7, 8}, {6, 8}, {7, 6}};
        //form the adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<10;i++)adjList.add(new ArrayList<>());
        for(int[]edge:edges){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println(Arrays.toString(shortestPath(0,adjList)));
    }
}
