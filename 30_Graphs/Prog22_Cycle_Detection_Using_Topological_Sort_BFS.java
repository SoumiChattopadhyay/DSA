import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog22_Cycle_Detection_Using_Topological_Sort_BFS {
    public static boolean checkCycle(int V,ArrayList<ArrayList<Integer>> adjList){
        //find indegree of each node
        int indegree[] = new int[V];
        for(int i=0;i<V;i++){
            for(int neighbor:adjList.get(i)){
                indegree[neighbor]++;
            }
        }
        //Initial config. of queue
        //push the nodes with indegree=0 in the queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int count=0;
        // Why would there be minimum one node with indegree 0?
        // Since the graph is a DAG (acyclic), it must have at least one node with 
        // indegree 0 (a "starting point" node). If every node had indegree ≥ 1 which is not possible, then we could keep following incoming edges indefinitely → this would eventually form a cycle.
        while(!q.isEmpty()){
            int node = q.remove();
            count++;
            for(int neighbor:adjList.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        if(count==V){
            return false;//no cycle
        }
        return true;//cycle
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>(Arrays.asList(
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>(Arrays.asList(3)),
            new ArrayList<>(Arrays.asList(1)),
            new ArrayList<>(Arrays.asList(0,1)),
            new ArrayList<>(Arrays.asList(0,2))));
        System.out.println(checkCycle(6, adjList));
            
        adjList=new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1)),
            new ArrayList<>(Arrays.asList(2)),
            new ArrayList<>(Arrays.asList(3)),
            new ArrayList<>(Arrays.asList(3))
        ));
        System.out.println(checkCycle(4, adjList));
    }
}
