import java.util.ArrayList;
import java.util.List;

public class Prog43_Disjoint_Set {
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
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);//pass no. of nodes to Constructor which will keep the initial configuration ready for us - where every node is a parent of itself
        ds.union_by_Rank(1, 2);
        ds.union_by_Rank(2,3);
        ds.union_by_Rank(4,5);
        ds.union_by_Rank(6,7);
        if(ds.findUPar(1)==ds.findUPar(4)){
            System.out.println("Same component");
        }else{
            System.out.println("Not same component");
        }
        ds.union_by_Rank(5,6);
        ds.union_by_Rank(3,7);
        if(ds.findUPar(1)==ds.findUPar(4)){
            System.out.println("Same component");
        }else{
            System.out.println("Not same component");
        }
    }
    // you can create multiple objects and reuse the code multiple times for any no. of nodes and both 1 and 0 based indexing graph
    // DisjointSet ds2 = new DisjointSet(6);
}
