import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
class Tuple{
    int weight;
    int node;
    int parent;
    Tuple(int weight,int node,int parent){
        this.weight=weight;
        this.node=node;
        this.parent=parent;
    }
}
class Pair{
    int weight;
    int node;
    Pair(int weight,int node){
        this.weight=weight;
        this.node=node;
    }
}
public class Prog42_Prim_Algorithm_to_find_MST {
    public static void findMST(int[][]edges,int n){
        //find adjacency List
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adjList.get(u).add(new Pair(wt,v));
            adjList.get(v).add(new Pair(wt,u));
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((x,y)->{return x.weight-y.weight;});
        int[]visited=new int[n];
        List<List<Integer>> mst = new ArrayList<>();
        
        pq.add(new Tuple(0,0,-1));
        int sum=0;
        //TC=O(E*log E + E*log E)= O(E*log E)
        while(!pq.isEmpty()){
            //log E
            Tuple it = pq.poll();
            int wt=it.weight;
            int node=it.node;
            int parent=it.parent;
            
            if(visited[node]==1)continue;
            
            visited[node]=1;
            if(parent!=-1){
                ArrayList<Integer> ls = new ArrayList<>();
                ls.add(parent);
                ls.add(node);
                mst.add(ls);
                sum+=wt;
            }
            //E * log E
            for(Pair p:adjList.get(node)){
                int edgeWt=p.weight;
                int neighbor=p.node;
                if(visited[neighbor]==0){
                    pq.add(new Tuple(edgeWt, neighbor, node));
                }
            }
        }
        //printing MST edgeList
        System.out.println(mst);
        //printing MST weight
        System.out.println("Total Weight of MST: "+sum);
    }
    public static void main(String[] args) {
        int edges[][] = {
            {0,1,2},
            {0,2,1},
            {1,2,1},
            {2,3,2},
            {2,4,2},
            {3,4,1}
        };
        findMST(edges, 5);
    }
}
