// https://leetcode.com/problems/accounts-merge/description//
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Prog48_Accounts_Merge {
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
    public static List<List<String>> accMerge(String[][] details) {
        DisjointSet ds = new DisjointSet(details.length);
        HashMap<String,Integer> mapMailNode = new HashMap<>();
        for(int i=0;i<details.length;i++){
            for(int j=1;j<details[i].length;j++){
                String mail = details[i][j];
                if(mapMailNode.containsKey(mail)==false){
                    mapMailNode.put(mail, i);
                }else{
                    ds.union_by_Size(mapMailNode.get(mail), i);
                }
            }
        }//now DSU formed 
        ArrayList<ArrayList<String>> mergedMails = new ArrayList<>();
        for(int i=0;i<details.length;i++){
            mergedMails.add(new ArrayList<>());
        }
        // iterate over map
        for(Map.Entry<String,Integer> it : mapMailNode.entrySet()){
            String mail = it.getKey();
            int node = it.getValue();
            int ulp_node = ds.findUPar(node);
            mergedMails.get(ulp_node).add(mail);
        }
        List<List<String>> ans = new ArrayList<>();
        for(int i=0;i<details.length;i++){
            if(!mergedMails.get(i).isEmpty()){
                Collections.sort(mergedMails.get(i));
                List<String> temp = new ArrayList<>();
                temp.add(details[i][0]);
                for(String it:mergedMails.get(i)){
                    temp.add(it);
                }
                ans.add(temp);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        String[][] arr = {
            {"John", "J1@com", "J2@com", "J3@com"},
            {"John", "J4@com"},
            {"raj", "r1@com", "r2@com"},
            {"John", "J1@com", "J5@com"},
            {"raj", "r2@com", "r3@com"},
            {"Mary", "M1@com"}
        };
        System.out.println(accMerge(arr));
    }
}
