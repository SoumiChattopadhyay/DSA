import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class Prog2_BFS {   

    //TC=O(N+2*E), SC=O(3*N)=O(N)
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){//function to return bfs of a graph
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean[] visited = new boolean[V+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);//graph is 1-based indexed
        visited[1]=true;

        while(!q.isEmpty()){
            int node = q.poll();
            bfs.add(node);

            for(int neighbor:adj.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor]=true;
                    q.add(neighbor);
                }

            }
            //for(int j=0;j<adj.get(node).length;j++){
                //if (!visited[j]){
                // q.add(j);
                // visited[j]=false;
                // }
            // }
        }
        return bfs;
    }
}
