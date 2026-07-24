import java.util.ArrayList;
import java.util.List;
public class Prog44_Disjoint_Set2 {
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
            else{
                parent.set(ulp_v,ulp_u);
                size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
            }
        }
    }
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);//pass no. of nodes to Constructor which will keep the initial configuration ready for us
        ds.union_by_Size(1, 2);
        ds.union_by_Size(2,3);
        ds.union_by_Size(4,5);
        ds.union_by_Size(6,7);
        if(ds.findUPar(1)==ds.findUPar(4)){
            System.out.println("Same component");
        }else{
            System.out.println("Not same component");
        }
        ds.union_by_Size(5,6);
        ds.union_by_Size(3,7);
        if(ds.findUPar(1)==ds.findUPar(4)){
            System.out.println("Same component");
        }else{
            System.out.println("Not same component");
        }
    }
}
