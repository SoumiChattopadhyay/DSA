import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Prog45_Kruskals_Algorithm {
    static class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;
        Edge(int src,int dest,int weight){
            this.src=src;
            this.dest=dest;
            this.weight=weight;
        }
        public int compareTo(Edge compareEdge){ 
            return this.weight-compareEdge.weight;//ascending order.//if returns -ve val => 2 conclusions: this comes before & this is smaller,//if returns +ve val => 2 conclusions: this comes after & this is larger, so ascending order
        //  return compareEdge.weight-this.weight;//descending order.//if returns -ve val => 2 conclusions: this comes before & this is larger,//if returns +ve val => 2 conclusions: this comes after & this is smaller, so descending order
        }//for MST you must sort in ascending order of weight only
    }
    static class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){//taking i till n works for both 0-based index graph & 1-based index graph
                size.add(1);
                parent.add(i);//You need to use .add() to fill the lists first..set() only works on existing indices. 
            }
        }
        public int findUPar(int node){
            if(node==parent.get(node)){
                return node;
            }
            //Path Compression
            int ulp_node=findUPar(parent.get(node));//keep it then return it
            parent.set(node,ulp_node);
            return ulp_node;
        }
        public void union_by_Size(int u, int v){
            int ulp_u=findUPar(u);
            int ulp_v=findUPar(v);
            if(ulp_u==ulp_v){// already in same component. Nothing to do
                return;
            }
            if(size.get(ulp_v)>size.get(ulp_u)){
                parent.set(ulp_u,ulp_v);
                size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
            }
            else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }
    static int minimum_Spanning_Tree(int n,ArrayList<ArrayList<ArrayList<Integer>>> adjList){
        List<Edge> edgeList = new ArrayList<>();
        //O(N+E)
        for(int u=0;u<=n;u++){
            for(int j=0;j<adjList.get(u).size();j++){
                int v = adjList.get(u).get(j).get(0);//v is neighbor node
                int wt = adjList.get(u).get(j).get(1);
                Edge e = new Edge(u,v,wt);
                edgeList.add(e);
            }
        }
        DisjointSet ds = new DisjointSet(n);
        //O(ElogE)
        Collections.sort(edgeList);
        int mstWt=0;
        //O(E*4*alpha*2)
        for(int i=0;i<edgeList.size();i++){
            int u=edgeList.get(i).src;
            int v=edgeList.get(i).dest;
            int wt=edgeList.get(i).weight;

            if(ds.findUPar(u)!=ds.findUPar(v)){//don't belong to same component
                mstWt+=wt;
                ds.union_by_Size(u, v);
            }
        }
        return mstWt;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adjList = new ArrayList<>();
        int n=6;
        for(int u=0;u<=n;u++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(1).add(new ArrayList<>(Arrays.asList(2,2)));
        adjList.get(1).add(new ArrayList<>(Arrays.asList(4,1)));
        adjList.get(1).add(new ArrayList<>(Arrays.asList(5,4)));
        adjList.get(2).add(new ArrayList<>(Arrays.asList(1,2)));
        adjList.get(2).add(new ArrayList<>(Arrays.asList(3,3)));
        adjList.get(2).add(new ArrayList<>(Arrays.asList(6,7)));
        adjList.get(3).add(new ArrayList<>(Arrays.asList(4,5)));
        adjList.get(3).add(new ArrayList<>(Arrays.asList(2,3)));
        adjList.get(3).add(new ArrayList<>(Arrays.asList(6,8)));
        adjList.get(4).add(new ArrayList<>(Arrays.asList(5,9)));
        adjList.get(4).add(new ArrayList<>(Arrays.asList(1,1)));
        adjList.get(4).add(new ArrayList<>(Arrays.asList(2,3)));
        adjList.get(4).add(new ArrayList<>(Arrays.asList(2,3)));
        adjList.get(4).add(new ArrayList<>(Arrays.asList(3,5)));
        adjList.get(5).add(new ArrayList<>(Arrays.asList(1,4)));
        adjList.get(5).add(new ArrayList<>(Arrays.asList(4,9)));
        adjList.get(6).add(new ArrayList<>(Arrays.asList(2,7)));
        adjList.get(6).add(new ArrayList<>(Arrays.asList(3,8)));

        System.out.println("Sum of edge weights of MST = "+minimum_Spanning_Tree(n,adjList));
    }
}