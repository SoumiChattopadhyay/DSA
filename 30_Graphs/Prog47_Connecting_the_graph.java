// https://www.geeksforgeeks.org/problems/connecting-the-graph/1
// Connecting the graph
// You are given a graph with n vertices (0 to n-1) and m edges. 
// You can remove one edge from anywhere and add that edge between any two vertices in one operation. 
// Find the minimum number of operations that will be required to connect the graph.
// If it is not possible to connect the graph, return -1.

import java.util.ArrayList;
import java.util.List;

public class Prog47_Connecting_the_graph {
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
            int ulp_node=findUPar(parent.get(node));
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
            else{//when (size.get(ulp_v)<=size.get(ulp_u))
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }
    public static int findMinOp(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);
        int cntExtras=0;
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            if(ds.findUPar(u)==ds.findUPar(v)){//you should not use parent.get(u) directly here. You must use findUPar(u) becoz In a Disjoint Set the parent[] array (or List) doesn’t always store the ultimate parent of a node — at least not until path compression has been applied.
                cntExtras++;
            }else{
                ds.union_by_Size(u, v);
            }
        }
        int cntC=0;
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i){
                cntC++;
            }
        }
        int ans=cntC-1;
        if(cntExtras>=ans) return ans;
        return -1;
    }
    public static void main(String[] args) {
        int n=9;
        int edges[][]=new int[][]{{0,1},{0,2},{0,3},{1,2},{2,3},{4,5},{5,6},{7,8}};
        findMinOp(n, edges);
    }
}
