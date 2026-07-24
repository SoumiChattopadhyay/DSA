// There are n cities connected by some number of flights. 
// You are given an array flights where flights[i] = [fromi, toi, pricei] indicates 
// that there is a flight from city fromi to city toi with cost pricei.
// You are also given three integers src, dst, and k, 
// return the cheapest price from src to dst with at most k stops. 
// If there is no such route, return -1.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
class Pair{
    int node;
    int edgeWt;
    Pair(int node,int edgeWt){
        this.node=node;
        this.edgeWt=edgeWt;
    }
}
class Tuple{
    int stops;
    int node;
    int cost;
    public Tuple(int stops, int node, int cost) {
        this.stops=stops;
        this.node=node;
        this.cost=cost;
    }
}
public class Prog36_Cheapest_Flight_Within_k_stops {
     public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        //Create graph: form adjacency list
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)adjList.add(new ArrayList<>());
        for(int edge[]:flights){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adjList.get(u).add(new Pair(v,wt));//Flights are directed graphs
        }
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0,src,0));
        
        int[] dist = new int[n];
        for(int i=0;i<n;i++)dist[i]=(int)1e9;
        dist[src]=0;

        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stops = it.stops;
            int node = it.node;
            int cost = it.cost;
            if(node==dst || stops==k+1){//or if(stops>k)
                continue;
            }
            for(Pair p:adjList.get(node)){
                int neighbor=p.node;
                int wt=p.edgeWt;
                if(cost+wt<dist[neighbor] && stops<=k){//this should be stops<=k becoz in next step stops will be incremented . so if stops is 2 then only 3 is allowed, but if stops is 3 then i.e stops is not <=k then 4 isnt allowed
                    q.add(new Tuple(stops+1, neighbor, cost+wt));
                    dist[neighbor]=cost+wt;
                }
            }
        }
        if(dist[dst]==(int)1e9){
            return -1;
        }
        return dist[dst];
    }
    public static void main(String[] args) {
        int flights[][]= new int[][]{
            {0,1,5},
            {0,3,2},
            {1,2,5},
            {1,4,1},
            {3,1,2},
            {4,2,1}
        };
        flights = new int[][]{
            {0, 1, 100},
            {1, 3, 100},
            {0, 2, 1},
            {2, 3, 10}
        };

        System.out.println(findCheapestPrice(5, flights, 0, 3, 2));
    }
}
