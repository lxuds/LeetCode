// time complexity: (26 ^ W * N)
// space complexity: (26 ^ W * N)
// w: the width of the word; N is the number of the words in the wordList
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> dict = new HashSet<String>(wordList);
        
        if (!dict.contains(endWord)){
            return 0;
        }
        
        queue.add(beginWord);
        int level = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            level++;                

            for (int i = 0; i < size; i ++){
                String word = queue.poll();
                if (word.equals(endWord)){
                    return level;
                } 
                List<String> neighbors = findNeighbors(word, dict);
                for (String nb: neighbors){
                    if (!visited.contains(nb)){
                        visited.add(nb);
                        dict.remove(nb);
                        queue.add(nb);
                    }
                }
            }
        }
        return 0;
    }
    
    // generate word list that one letter differenct from word 
    private List<String> findNeighbors(String word, Set<String> dict){
        List<String> neighbors = new ArrayList<>();
        for (int i = 0; i < word.length(); i++){
            for (char c = 'a'; c <= 'z'; c++){
                if (c != word.charAt(i)){
                    String newWord = word.substring(0,i) + c + word.substring(i+1);
                    if (dict.contains(newWord)){
                        neighbors.add(newWord);
                    }
                }
            }
        }
        return neighbors;
    }
        
    
}
