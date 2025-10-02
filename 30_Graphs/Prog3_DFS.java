import java.util.ArrayList;
public class Prog3_DFS {
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>>adj){
        ArrayList<Integer> ls = new ArrayList<>();
        boolean visited[] = new boolean[V+1];
        dfs(1,ls,visited,adj);
        // //for handing disconnected components
        // for(int i=1;i<=V;i++){
        //     if(!visited[i]){
        //         dfs(i,ls,visited,adj);
        //     }
        // }
        return ls;//arraylist is object so reference is passed, so any modifications made in that funct is reflected here also coz no copy is passed
    }
    //dfs() funct is called N times for N nodes so O(N)
    private void dfs(int node,ArrayList<Integer> ls,boolean[]visited,ArrayList<ArrayList<Integer>>adj){
        visited[node]=true;//O(1)
        ls.add(node);//O(1)
        for(int neighbor:adj.get(node)){//every time this loop is running for adj.get(node).length times or length of neighbour list times. So total no. of times the loop is running = sum of length of all neighbour lists = sum of degrees of all nodes = 2*E (neighbor list length of a node = degree of that node)
            if(!visited[neighbor])//O(1)
                dfs(neighbor,ls,visited,adj);
        }
    }
    //dfs() funct is called only N times for N nodes so O(1)*N = O(N). (O(1) for marking visited as 1 and O(1) for adding node to the list so O(1)+O(1)=O(1))
    // the for loop inside the funct is called neighbor-list.length times for each node i.e. 2E times total so O(2E)
    //So TC=O(N)+O(2E) = O(N+2E)
}
/*Algorithm(DFS):
 1. First we mark 1 as visited and add it to the arraylist and then take the neighbour-list of 1,
 make a call for 2, now mark 2 as visited and add it to the arraylist and then take the neighbour-list of 2,
 now since in that neighbor-list 1 is already visited make a call for 5, now mark 5 as visited and add it to the arraylist and then take the neighbour-list of 5,
 now since in that neighbor-list 2 is already visited loop ends and recursion call returns to the previous call where node is 2, now make a call for 6,now mark 6 as visited and add it to the arraylist and then take the neighbour-list of 6,
 now since in that neighbor-list 2 is already visited loop ends and recursion call returns to the previous call where node is 2 and there also the loop ends so control goes to previous recursion call where node is 1, now make a call for 3,
 mark 3 as visited and add it to the arraylist and then take the neighbour-list of 3,since 1 is visited so skip and make a call for 4, now mark 4 as visited add it to arraylist and take its neighbor-list, since there 3 already visited so skip and make call for 8
 */