// Map Interface: https://docs.oracle.com/javase/8/docs/api/java/util/Map.html
//Set Interface: https://docs.oracle.com/javase/8/docs/api/java/util/Set.html
import java.util.HashMap;
import java.util.TreeMap;
import java.util.HashSet;
public class Prog2{
    public static void main(String[] args) {
        //HashMap : https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html
        HashMap<String,Integer> map = new HashMap<>();
        map.put("Kunal",99);
        map.put("Karan",78);
        map.put("Riya",89);
        
        System.out.println(map);//{Karan=78, Kunal=99, Riya=89}
        System.out.println(map.get("Kunal"));//99
        System.out.println(map.getOrDefault("Apoorv", 60));//60

        map.replace("Karan", 100);
        System.out.println(map.replace("Kunal",99, 100));//true
        System.out.println(map);//{Karan=100, Kunal=100, Riya=89}
        System.out.println(map.containsKey("Kunal"));

        //TreeMap:https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html
        TreeMap<String,Integer> map2 = new TreeMap<>();
        map2.put("Kunal",99);
        map2.put("Karan",78);
        map2.put("Riya",89);
        System.out.println(map2);//{Karan=78, Kunal=99, Riya=89}

        // HashSet: https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html
        HashSet<Integer> set = new HashSet<>();
        set.add(99);
        set.add(78);
        set.add(78);
        set.add(99);
        set.add(80);
        set.add(80);
        System.out.println(set);//[80, 99, 78]
    }
}