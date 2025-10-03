import java.util.LinkedList;
import java.util.Queue;
public class Prog16_Bipartite_Graph_using_BFS{
    // Graph is bipartite if you can color the graph with 2 colors such that 
    // no adjacent nodes have the same color
    public static boolean isBipartite(int[][]adjList){
        int n=adjList.length;
        int[] visited = new int[n];
        for(int i=0;i<n;i++)visited[i]=-1;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                q.add(i);//i will be then the starting point of a particular component
                visited[i]=0;
                if(!bfs(adjList,visited,q)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean bfs(int[][] adjList,int[] visited,Queue<Integer> q){
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            for(int neighbor:adjList[node]){//only color the nodes adjacent to the dequeued node
                //if adjacent node not yet colored 
                //give the opposite color of the node
                if(visited[neighbor]==-1){
                    q.add(neighbor);//if 0 then 1-0=1, if 1 then 1-1=0
                    visited[neighbor]=1-visited[node];
                }
                //is the adjacent guy having the same color
                // someone did color it on some other path 
                else if(visited[neighbor]==visited[node]){
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        // int[][]adjList = {{1,2,3},{0,2},{0,1,3},{0,2}};//false
        int[][]adjList = {{1,3},{0,2},{1,3},{0,2}};//true
        System.out.println(isBipartite(adjList));
    }
}
