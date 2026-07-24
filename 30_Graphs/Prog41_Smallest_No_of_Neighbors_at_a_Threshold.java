// https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prog41_Smallest_No_of_Neighbors_at_a_Threshold {
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
         
        // form adjacency matrix(dist)
        int[][] dist = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        int m=edges.length;
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            dist[u][v]=wt;
            dist[v][u]=wt;
        }
        //each city must have dist=0 to itself
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        
        // Apply floyd warshall algo.
        for(int via=0;via<n;via++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][via]!=Integer.MAX_VALUE && dist[via][j]!=Integer.MAX_VALUE){
                        dist[i][j]=Math.min(dist[i][via]+dist[via][j],dist[i][j]);
                    }
                }
            }
        }

        // Find the city with smallest no. of neighbors
        int cntMin=distanceThreshold+1;
        int city=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=cntMin){
                cntMin=cnt;
                city=i;
            }
        }
        return city;//return city
        // return cntMin-1;// return smallest no. of neighbors of that city 
    }
    //using Dijkstra's algoritm
    public static int findTheCity2(int n, int[][] edges, int distanceThreshold){ 
         //form adjacency list
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)adjList.add(new ArrayList<>());
        for(int edge[]:edges){//O(m)
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adjList.get(u).add(new Pair(wt,v));
            adjList.get(v).add(new Pair(wt,u));
        }
        int[][]dist=new int[n][n];
        for(int i=0;i<n;i++){
            int[]temp=dijkstra(i, n, adjList);
            for(int j=0;j<n;j++){
                dist[i][j]=temp[j];
            }
        }
        int cntMin=distanceThreshold+1;
        int city=-1;
        for(int i=0;i<n;i++){
            int cnt=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold){
                    cnt++;
                }
            }
            if(cnt<=cntMin){
                cntMin=cnt;
                city=i;
            }
        }
        return city;
    }
    static class Pair{
        int distance;
        int node;
        Pair(int distance,int node){
            this.distance=distance;
            this.node=node;
        }
    }
    private static int[] dijkstra(int src,int n,ArrayList<ArrayList<Pair>>adjList){
       
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->{return x.distance-y.distance;});
        pq.add(new Pair(0,src));
        int dist[]=new int[n];
        for(int i=0;i<n;i++)dist[i]=Integer.MAX_VALUE;
        dist[src]=0;
        while(!pq.isEmpty()){
            // int distance=pq.peek().distance;
            int node=pq.peek().node;
            pq.remove();
            for(Pair p:adjList.get(node)){
                int neighbor=p.node;
                int edgeWt=p.distance;
                if(dist[node]+edgeWt<dist[neighbor]){
                    dist[neighbor]=dist[node]+edgeWt;
                    pq.add(new Pair(dist[neighbor],neighbor));
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold));
        System.out.println(findTheCity2(n, edges, distanceThreshold));
    }
}
