import java.util.ArrayList;
import java.util.Arrays;

public class Prog54_Articulation_Points {
    private int timer=0;
    private void dfs(int node, int parent,ArrayList<ArrayList<Integer>> adjList, int[] tin, int[] low, int[] visited, int[] mark){
        visited[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        int child=0;
        for(int adjNode:adjList.get(node)){
            if(adjNode==parent)continue;
            
            if(visited[adjNode]==0){
                dfs(adjNode, node, adjList, tin, low, visited,mark);
                low[node]=Math.min(low[node],low[adjNode]);
                // node---adjNode
                if(low[adjNode]>=tin[node] && parent!=-1){//adjNode can't reach before node, even if it goes via its subsequent adj nodes coz its low is >= time of insertion of node so it cant go before node it can only go at node or after node which isnt useful coz then if node is removed graph will be broken to components coz adjNode's only connection was node nothing before node
                    mark[node]=1;
                }
                child++;
            }
            
            else{
                low[node]=Math.min(low[node],tin[adjNode]);
            }
        }
        if(child>1 && parent==-1){
            mark[node]=1;
        }
    }
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adjList) {
        int[] visited = new int[V];
        int[] tin = new int[V];
        int[] low = new int[V];
        int[] mark = new int[V];
        ArrayList<Integer> artPts = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(visited[i]==0)
                dfs(0, -1, adjList, tin, low, visited,mark);
        }
        for(int i=0;i<V;i++){
            if(mark[i]==1)
                artPts.add(i);
        }
        if(artPts.size()==0)
            artPts.add(-1);
        
        return artPts;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<7; i++){
            adjList.add(new ArrayList<>());
        }
        adjList.get(0).addAll(Arrays.asList(1,2,3));
        adjList.get(1).addAll(Arrays.asList(0));
        adjList.get(2).addAll(Arrays.asList(0,3,4,5));
        adjList.get(3).addAll(Arrays.asList(0,2));
        adjList.get(4).addAll(Arrays.asList(2,6));
        adjList.get(5).addAll(Arrays.asList(2,6));
        adjList.get(6).addAll(Arrays.asList(4,5));

        Prog54_Articulation_Points obj = new Prog54_Articulation_Points();
        System.out.println(obj.articulationPoints(7, adjList));
    }
}
