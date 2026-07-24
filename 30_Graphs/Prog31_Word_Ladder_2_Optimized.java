import java.util.ArrayList;
import java.util.List;

public class Prog31_Word_Ladder_2_Optimized {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
    }
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        Prog31_Word_Ladder_2_Optimized obj = new Prog31_Word_Ladder_2_Optimized();
        System.out.println(obj.findLadders("hit", "cog", words));
        // One shortest transformation sequence is:
        // hit --> hot --> dot --> dog --> cog
    }
}
