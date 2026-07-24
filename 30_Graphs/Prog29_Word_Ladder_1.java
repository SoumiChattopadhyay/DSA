import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
public class Prog29_Word_Ladder_1 {
    class Pair{
        String first;
        int second;
        Pair(String f,int s){
            first=f;
            second=s;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //BFS
        Queue<Pair> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        for(int i=0;i<wordList.size();i++)wordSet.add(wordList.get(i));
        q.add(new Pair(beginWord,1));//step no.=1, 1st word in sequence
        wordSet.remove(beginWord);
        while(!q.isEmpty()){
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            if(word.equals(endWord))return steps;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch <='z';ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=ch;
                    // String replacedWord = replacedCharArray.toString();
                    String replacedWord = new String(replacedCharArray);
                    if(wordSet.contains(replacedWord)){
                        wordSet.remove(replacedWord);
                        q.add(new Pair(replacedWord,steps+1));
                    }
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("hot");
        words.add("dot");
        words.add("dog");
        words.add("lot");
        words.add("log");
        words.add("cog");
        Prog29_Word_Ladder_1 obj = new Prog29_Word_Ladder_1();
        System.out.println(obj.ladderLength("hit", "cog", words));
        // One shortest transformation sequence is:
        // hit --> hot --> dot --> dog --> cog
    }
}
