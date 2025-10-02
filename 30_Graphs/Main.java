import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prog1_graph_storing_methods obj1 = new Prog1_graph_storing_methods();
        // obj1.method1();
        ArrayList<ArrayList<Integer>> adj = obj1.method2();
        // obj1.store_in_weightedGraph();

        Prog2_BFS obj2 = new Prog2_BFS();
        obj2.bfsOfGraph(adj.size(), adj);//adj.size() will give the no. of vertices
        
        Prog3_DFS obj3 = new Prog3_DFS();
        obj3.dfsOfGraph(adj.size(), adj);//adj.size() will give the no. of vertices
    }
}
