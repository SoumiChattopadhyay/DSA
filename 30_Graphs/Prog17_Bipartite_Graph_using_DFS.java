public class Prog17_Bipartite_Graph_using_DFS {
    public static boolean isBipartite(int[][]adjList){
        int n=adjList.length;
        int[] visited=new int[n];
        for(int i=0;i<n;i++)visited[i]=-1;
        for(int i=0;i<n;i++){
            if(visited[i]==-1){
                if(!dfs(i,0,adjList, visited)){
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean dfs(int node,int color,int[][] adjList,int[] visited){
        visited[node]=color;
        for(int neighbor:adjList[node]){
            if(visited[neighbor]==-1){
                if(!dfs(neighbor,1-color,adjList,visited)){//Dont ignore the returned value of a deeper call, if it is false then return false
                    return false;
                }
            }
            else if(visited[neighbor]==visited[node]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][]adjList = {{1,2,3},{0,2},{0,1,3},{0,2}};//false
        int[][]adjList2 = {{1,3},{0,2},{1,3},{0,2}};//true
        System.out.println(isBipartite(adjList));
        System.out.println(isBipartite(adjList2));
    }
}
