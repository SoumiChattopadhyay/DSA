import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Prog23_Course_Schedule_I {
    //using bfs(toposort)
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // numCourses--> V, prerequisites--> edgeList
        //detect cycle or not --> task incomplete or not
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adjList.add(new ArrayList<>());
        for(int[]edge:prerequisites){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
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
        int count=0;
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
        if(count==numCourses){
            return true;
        }
        return false;
    }
    //using dfs
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        // numCourses--> V, prerequisites--> edgeList
        //detect cycle or not --> task incomplete or not
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adjList.add(new ArrayList<>());
        for(int[]edge:prerequisites){
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
        }
        int[] visited=new int[numCourses];
        int[] pathVisited=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(dfs(i, visited,pathVisited,adjList,numCourses)==true){//if cycle found
                return false;// courses can't be completed
            }
        }
        return true;
    }
    private static boolean dfs(int node,int[] visited,int[] pathVisited,ArrayList<ArrayList<Integer>> adjList,int numCourses){
        visited[node]=1;
        pathVisited[node]=1;
        for(int neighbor:adjList.get(node)){
                if(visited[neighbor]==0){
                    if(dfs(neighbor, visited, pathVisited, adjList, numCourses)==true){
                        return true;
                    }
                }
                else if(pathVisited[neighbor]==1){
                    return true;
                }
        }
        pathVisited[node]=0;
        return false;
    }
    public static void main(String[] args) {
        int edges[][]=new int[][]{
            {1,0},
            {2,1},
            {3,2}
        };
        System.out.println(canFinish(4, edges));
        System.out.println(canFinish2(4, edges));
    }
}
