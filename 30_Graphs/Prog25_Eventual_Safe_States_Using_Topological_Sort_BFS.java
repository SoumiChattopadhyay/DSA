import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prog25_Eventual_Safe_States_Using_Topological_Sort_BFS {
    //TC=O(N+E)
    //SC=O(N)
    // You need extra space of O(N) for adjRev ArrayList 
    // If u didnt use checkSafe array and stored the nodes directky in safeNodes Arraylist
    // and used Collections to reverse the safeNodes Arraylist 
    // then you will get extra TC of O(NlogN) in worst case
       public static List<Integer> eventualSafeNodes(int[][] adjList) {
        int V = adjList.length;
        // reverse the edges
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjRev.add(new ArrayList<>());
        } 
        for(int i=0;i<V;i++){
            for(int neighbor:adjList[i]){
                adjRev.get(neighbor).add(i);
            }
        }
        //find indegree of each node
        int indegree[]=new int[V];
        for(int i=0;i<V;i++){
            for(int neighbor:adjRev.get(i)){
                indegree[neighbor]++;
            }
        }
        // Initial config of queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int[] checkSafe = new int[V];
        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            checkSafe[node]=1;
            for(int neighbor:adjRev.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        for(int i=0;i<V;i++){
            if(checkSafe[i]==1){
                safeNodes.add(i);
            }
        }
        // Collections.sort(safeNodes);//sorts arraylist
        return safeNodes;
    }
    public static void main(String[] args) {
        // On the same path if you visit any node again, then cycle exists
        int[][] adjList = new int[][]{{1}, {2}, {3}, {4,5},{6},{6},{7},{},{1,9},{10},{8},{9}};//true
        List<Integer> ans = eventualSafeNodes(adjList);
        for(int item:ans){
            System.out.print(item+",");
        }
    }
}
