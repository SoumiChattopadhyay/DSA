import java.util.ArrayList;

public class Prog1_graph_storing_methods{
    public void method1() {
        
        //1. Using Adjacency Matrix: TC=O(M), SC=O(N^2). Inefficient method. Use only for small graphs.
        
        int[][] edges = {{1,2},{1,3},{2,4},{3,4},{2,5},{4,5}};// Edge list
        // int m = edges.length;//no. of edges
        int n = 5;//no. of vertices
        int[][] adj = new int[n+1][n+1]; // 1-based indexing
        
        // Fill adjacency matrix
        for(int[]edge :edges){
            int u = edge[0];
            int v = edge[1];// u and v are 2 nodes of that particular edge
            adj[u][v]=1;
            adj[v][u]=1;// since undirected
        }

         // Print adjacency matrix(TC=O(N^2))
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(adj[i][j] + " ");
            }
            System.out.println();
        }
    }
    public void method2(){

        //2. Using Adjacency List: TC=O(N^2), SC=O(2M).

        int[][] edges = {{1,2},{1,3},{2,4},{3,4},{2,5},{4,5}};// Edge list
        // int m = edges.length;//no. of edges
        int n = 5;//no. of vertices

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();//adj is a list containing n lists, where each list stores the neighbour nodes of a particular node. we can say idx represents the particular node and list at that idx contains the neighbous of the node
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());//fill adj with n+1 empty arraylists
        }

        for(int[]edge:edges){
            int u = edge[0];
            int v=edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);//since undirected graph
        }

        for(int i=1;i<=n;i++){
            System.out.print(i + " -> ");
            // for (int neighbor : adj.get(i)) {
            //     System.out.print(neighbor + " ");
            // }
            for(int j=0;j<adj.get(i).size();j++){
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public static void store_in_weightedGraph(){
        int[][] edges = {{1,2,4},{1,3,2},{2,4,7},{3,4,1},{2,5,3},{4,5,5}};// Edge list 
        
    }
    public static void main(String[] args) {
        Prog1_graph_storing_methods obj = new Prog1_graph_storing_methods();
        // obj.method1();
        obj.method2();
    }
// Important points:
//arraylists and arrays follow 0-based indexing but u have to store the vertices based on 1-based indexing so take the array size and arraylist size as n+1

//If directed graph given:
//for adjacency matrix method only do adj[u][v]=1
//for adjacency list method only do adj.get(u).add(v)

//If weighted graph given:
//for adjacency matrix method just do adj[u][v]= wt. (edge weight)
//for adjacency list just store each neighbour and wt. together in a list. So it will be a list of lists
}
