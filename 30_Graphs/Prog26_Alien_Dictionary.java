import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prog26_Alien_Dictionary {
    public static String findOrder(String[] alienDict, int N, int K){
        //form the directed graph
        //by forming its adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<K;i++){
            adjList.add(new ArrayList<>());
        }
        for(int i=0;i<N-1;i++){//go till second last string of dict
            String s1 = alienDict[i];
            String s2 = alienDict[i+1];
            int len = Math.min(s1.length(),s2.length());
            boolean foundDifference = false;
            for(int j=0;j<len;j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    //the char at s1 will direct to the char at s2, so the char at s2 will be its neighbor
                    adjList.get(s1.charAt(j)-'a').add(s2.charAt(j)-'a');//u are not adding abcd.. u are adding 0123.. in the list
                    foundDifference=true;
                    break;//only one inequality between the 2 strings is required, further inequalities not needed 
                }
            }
            // Handle prefix conflict: e.g., "abc" before "ab"
            if (!foundDifference && s1.length() > s2.length()) {
                System.out.println("Invalid dictionary: '" + s2 + "' is a prefix of '" + s1 + "'");
                return "";
            }
        }
        //call topoSort 
        List<Integer> topo = topoSort(adjList,K);
        if(topo.isEmpty()){
            System.out.println("Invalid dictionary: cyclic dependency exists");
            return "";
        }
        StringBuilder ans=new StringBuilder();
        for(int it:topo){
            ans=ans.append((char)(it+(int)'a'));
        }
        return ans.toString();
    }
    private static List<Integer> topoSort(ArrayList<ArrayList<Integer>> adjList,int V){
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
        List<Integer> topo = new ArrayList<>();
        int cnt=0;
        while(!q.isEmpty()){
            int node = q.remove();
            topo.add(node);
            cnt++;
            for(int neighbor:adjList.get(node)){
                indegree[neighbor]--;//node is taken out of the queue and is part of topoSort array, so remove edge between node and neighbor
                if(indegree[neighbor]==0){
                    q.add(neighbor);
                }
            }
        }
        if(cnt==V){
            return topo;
        }
        return new ArrayList<>();
    }
    public static void main(String[] args) {
        String[] words = new String[]{"baa", "abcd", "abca", "cab", "cad"};
        int N = words.length;
        int K = 4;//uses only 4 chars. of English dict.
        System.out.println(findOrder(words, N, K));//bdac
        
        K=5;
        System.out.println(findOrder(words, N, K));//bedac // e is a single node. b comes before d in loop so order is bedac
        
        //Test Case 1: prefix conflict
        words = new String[]{"abcd", "abc"};
        K=4;
        N=2;
        System.out.println(findOrder(words, N, K));
        
        // Test Case 2: Cyclic dependency
        words = new String[]{"abcd", "bacd","acbd"};
        K=4;
        N=3;
        System.out.println(findOrder(words, N, K));
    }
}
