import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Prog53_Bridges_in_Graph {
    private int timer=1;
    private void dfs(int node,int parent,ArrayList<ArrayList<Integer>> adjList,List<List<Integer>> bridges, int[]visited, int[] tin, int[] low){
        visited[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        for(int it:adjList.get(node)){
            if(it==parent)continue;
            if(visited[it]==0){
                dfs(it, node, adjList, bridges, visited, tin, low);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    bridges.add(Arrays.asList(node,it));
                }
            }
            else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> edgeList) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            adjList.add(new ArrayList<>());
        }
        for(List<Integer> edge:edgeList){
            int u=edge.get(0);
            int v=edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int[] visited = new int[n+1];
        int[] tin = new int[n+1];
        int[] low = new int[n+1];
        List<List<Integer>> bridges = new ArrayList<>();
        dfs(1,-1,adjList,bridges,visited,tin,low);
        return bridges;
    }
    public static void main(String[] args) {
        List<List<Integer>> edgeList = new ArrayList<>();
        edgeList.add(Arrays.asList(1, 2));
        edgeList.add(Arrays.asList(1, 4));
        edgeList.add(Arrays.asList(2, 3));
        edgeList.add(Arrays.asList(3, 4));
        edgeList.add(Arrays.asList(4, 5));
        edgeList.add(Arrays.asList(5, 6));
        edgeList.add(Arrays.asList(6, 7));
        edgeList.add(Arrays.asList(6, 9));
        edgeList.add(Arrays.asList(7, 8));
        edgeList.add(Arrays.asList(8, 9));
        edgeList.add(Arrays.asList(8, 10));
        edgeList.add(Arrays.asList(10, 11));
        edgeList.add(Arrays.asList(10, 12));
        edgeList.add(Arrays.asList(11, 12));

        Prog53_Bridges_in_Graph obj = new Prog53_Bridges_in_Graph();
        System.out.println(obj.criticalConnections(12, edgeList));
    }
}
