import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
//TC=O(V+E)
//SC=O(V)
public class Prog20_Topological_Sorting_Using_DFS{
    public static int[] topoSort(int V,ArrayList<ArrayList<Integer>> adjList){
        Stack<Integer> st = new Stack<>();
        int[] visited = new int[V];
        for(int i=0;i<V;i++){
            if(visited[i]==0){
                dfs(i,visited,st,adjList);
            }
        }
        int[] arr = new int[V];
        int i=0;
        while(!st.isEmpty()){
            arr[i]=st.pop();
            i++;
        }
        return arr;
    }
    private static void dfs(int node,int[] visited,Stack<Integer> st,ArrayList<ArrayList<Integer>> adjList){
        visited[node]=1;
        for(int neighbor:adjList.get(node)){
            if(visited[neighbor]==0){
                dfs(neighbor, visited, st, adjList);
            }
        }
        st.push(node);
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adjList=new ArrayList<>(Arrays.asList(
            new ArrayList<>(),
            new ArrayList<>(),
            new ArrayList<>(Arrays.asList(3)),
            new ArrayList<>(Arrays.asList(1)),
            new ArrayList<>(Arrays.asList(0,1)),
            new ArrayList<>(Arrays.asList(0,2))));
        System.out.println(Arrays.toString(topoSort(6, adjList)));
    }
}
