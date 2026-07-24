import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prog24_Course_Schedule_II {
     public int[] findOrder(int numCourses, int[][] prerequisites) {
        // numCourses--> V, prerequisites--> edgeList
        //detect cycle or not --> task incomplete or not
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adjList.add(new ArrayList<>());
        for(int[]edge:prerequisites){
            int u = edge[0];
            int v = edge[1];
            adjList.get(v).add(u);//consider edge from v-->u. so u will be in v's neighbor list
        }
        //find indegree of each node
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int neighbor:adjList.get(i)){
                indegree[neighbor]++;
            }
        }
        // Initial config of queue
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        int topo[]=new int[numCourses];
        int count=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo[count]=node;
            count++;
            for(int neighbor:adjList.get(node)){
                indegree[neighbor]--;
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        if(count==numCourses){
            return topo;
        }
        return new int[]{};
    }
}
