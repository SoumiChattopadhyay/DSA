// https://www.geeksforgeeks.org/problems/number-of-provinces/1
// Given an undirected graph with V vertices. We say two vertices u and v belong to a single province if there is a path from u to v or v to u. Your task is to find the number of provinces.
// Note: A province is a group of directly or indirectly connected cities and no other cities outside of the group.

import java.util.ArrayList;
import java.util.List;
public class Prog46_No_of_Provinces {
    static class DisjointSet{
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n){
            for(int i=0;i<=n;i++){//taking i till n works for both 0-based index graph & 1-based index graph
                rank.add(0);
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
        public void union_by_Rank(int u, int v){
            int ulp_u=findUPar(u);
            int ulp_v=findUPar(v);
            if(ulp_u==ulp_v){// already in same component. Nothing to do
                return;
            }
            if(rank.get(ulp_v)>rank.get(ulp_u)){//smaller rank guy attached to bigger rank guy(update parent[smaller guy] to bigger rank guy)
                parent.set(ulp_u,ulp_v);
            }
            else if(rank.get(ulp_u)>rank.get(ulp_v)){
                parent.set(ulp_v,ulp_u);
            }
            else{//if both guys have have same rank attach one to another and increase rank of another by 1
                parent.set(ulp_v,ulp_u);
                rank.set(ulp_u,rank.get(ulp_u)+1);
            }
        }
    }
    public static int findCircleNum(int[][] adjMatrix) {
        int V=adjMatrix.length;
        DisjointSet ds = new DisjointSet(V);//pass no. of nodes to Constructor which will keep the initial configuration ready for us - where every node is a parent of itself
        for(int i=0;i<V;i++){//O(V^2)
            for(int j=0;j<V;j++){
                if(adjMatrix[i][j]==1){
                    ds.union_by_Rank(i, j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<V;i++){//O(V) //check question for 0-based or 1-based idx graph
            if(ds.parent.get(i)==i){//use this instead of ds.findUPar(i) to avoid recursion. findUPar takes O(4*alpha) while this takes only O(1)
                cnt++;
            }
        }
        return cnt;
    }
    // Same except adjMatrix given in form of Arraylist
     static int findCircleNum2(ArrayList<ArrayList<Integer>> adjMatrix, int V) {
        DisjointSet ds = new DisjointSet(V);//pass no. of nodes to Constructor which will keep the initial configuration ready for us - where every node is a parent of itself
        for(int i=0;i<V;i++){//O(V^2)
            for(int j=0;j<V;j++){
                if(adjMatrix.get(i).get(j)==1){
                    ds.union_by_Rank(i, j);
                }
            }
        }
        int cnt=0;
        for(int i=0;i<V;i++){//O(V) //check question for 0-based or 1-based idx graph
            if(ds.parent.get(i)==i){//use this instead of ds.findUPar(i) to avoid recursion. findUPar takes O(4*alpha) while this takes only O(1)
                cnt++;
            }
        }
        return cnt;
    }
    public static void main(String[] args) {
        int[][] adjMatrix = {
            {0, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0}
        };
        System.out.println(findCircleNum(adjMatrix));
    }
}