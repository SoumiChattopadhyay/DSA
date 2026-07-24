import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Prog30_Word_Ladder_2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        //BFS   
        Queue<List<String>> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>();
        for(int i=0;i<wordList.size();i++)wordSet.add(wordList.get(i));
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);
        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level=0;
        List<List<String>> ans = new ArrayList<>();
        //dont remove the word from the wordSet until the next levels are fully added in the queue
        while(!q.isEmpty()){
            List<String> vec = new ArrayList<>();
            vec=q.remove();
            // if I am on a newer level,I will remove all words from the wordSet
            // that have been used in the previous level to transform 
            if(vec.size()>level){
                level++;
                for(String it:usedOnLevel){
                    wordSet.remove(it);
                }
                usedOnLevel.clear();
            }
            String word = vec.get(vec.size()-1);//get the last word in the list
            if(word.equals(endWord)){
                //first sequence where we reach target
                if(ans.size()==0){
                    ans.add(vec);
                }
                else if(ans.get(0).size()==vec.size()){
                    ans.add(vec);
                }
            }
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch <='z';ch++){
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i]=ch;
                    // String replacedWord = replacedCharArray.toString();//This doesn’t convert the array into a readable string — it returns something like [C@3b6eb2ec.You should use new String(replacedCharArray).
                    String replacedWord = new String(replacedCharArray);
                    if(wordSet.contains(replacedWord)){
                        vec.add(replacedWord);
                        //You can never add vec in Queue as it is constantly getting modified
                        // and Java works by references
                        List<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        //mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(replacedWord);
                    }
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("pat");
        words.add("bot");
        words.add("pot");
        words.add("poz");
        words.add("coz");
        Prog30_Word_Ladder_2 obj = new Prog30_Word_Ladder_2();
        System.out.println(obj.findLadders("bat", "coz", words));
        System.out.println(obj.findLadders("pat", "coz", words));
        // All shortest transformation sequences are:
        // [[bat, pat, pot, poz, coz], [bat, bot, pot, poz, coz]]
}
}