// https://www.geeksforgeeks.org/problems/number-of-ways-to-arrive-at-destination/1
// You are in a city that consists of n intersections numbered from 0 to n - 1 with 
// bi-directional roads between some intersections. The inputs are generated such that 
// you can reach any intersection from any other intersection and that there is 
// at most one road between any two intersections.

// You are given an integer n and a 2D integer array roads where 
// roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi 
// that takes timei minutes to travel. You want to know in how many ways you can travel 
// from intersection 0 to intersection n - 1 in the shortest amount of time.

// Return the number of ways you can arrive at your destination in the shortest amount 
// of time. Since the answer may be large, return it modulo 10^9 + 7.

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class Pair{
    int node;
    long distance;
    Pair(long distance,int node){
        this.distance=distance;
        this.node=node;
    }
}
public class Prog38_No_of_Ways_to_Arrive_at_Destination {
    static long countPaths(int n, List<List<Integer>> roads) {
        int src=0;
        int dest=n-1;
        int mod=(int)(1e9+7);
        // Form adjacency list
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)adjList.add(new ArrayList<>());
        for(List<Integer> edge:roads){
            int u = edge.get(0);
            int v = edge.get(1);
            int wt = edge.get(2);
            adjList.get(u).add(new Pair(wt,v));
            adjList.get(v).add(new Pair(wt,u));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->{return Long.compare(x.distance,y.distance);});
        pq.add(new Pair(0,0));
        
        long []dist=new long[n];
        for(int i=0;i<n;i++)dist[i]=(long)1e18;
        dist[src]=0;
        
        int[]ways=new int[n];
        for(int i=0;i<n;i++)ways[i]=0;
        ways[src]=1;

        while(!pq.isEmpty()){
            int node=pq.peek().node;
            long d=pq.peek().distance;
            if(d>dist[node])continue;//dont process old entries
            pq.remove();
            for(Pair it:adjList.get(node)){
                int neighbor=it.node;
                long edgeWt=it.distance;
                //this is the first time a shorter path (path with shorter dist or shorter time as specified in question, edgeWt --> dist or time)
                //is reaching neighbor
                if(dist[node]+edgeWt<dist[neighbor]){
                    dist[neighbor]=dist[node]+edgeWt;
                    ways[neighbor]=ways[node];
                    pq.add(new Pair(dist[node]+edgeWt,neighbor));
                }
                else if(dist[node]+edgeWt==dist[neighbor]){
                    ways[neighbor]=(ways[neighbor]+ways[node])%mod;
                }
            }
        }
        return ways[dest]%mod;
    }
    public static void main(String[] args) {
        List<List<Integer>> edgeList = List.of(
            List.of(0, 1, 1),
            List.of(0, 2, 2),
            List.of(0, 3, 1),
            List.of(0, 4, 2),
            List.of(1, 5, 2),
            List.of(2, 5, 1),
            List.of(2, 7, 3),
            List.of(3, 6, 2),
            List.of(3, 7, 2),
            List.of(4, 6, 1),
            List.of(5, 8, 1),
            List.of(6, 8, 1),
            List.of(7, 8, 1)
        );
        System.out.println(countPaths(9, edgeList));
    }
}
