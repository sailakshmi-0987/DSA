class Solution {
    class Node{
        Node[] children=new Node[26];
        boolean eow = false;

        Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
        }
    }
    private Node root = new Node();
    public void insert(String word){
        Node curr = root;
        for(int level=0;level<word.length();level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow=true;
    }
    public boolean search(String key){
        Node curr = root;
        for(int level=0;level<key.length();level++){
            int idx = key.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow==true;
        
    }
    public boolean checkWord(String key, int start, Boolean[] memo) {
        if (start == key.length()) return true;
        if (memo[start] != null) return memo[start];

        Node curr = root;
        for (int end = start; end < key.length(); end++) {
            int idx = key.charAt(end) - 'a';
            if (curr.children[idx] == null) break;
            curr = curr.children[idx];
            if (curr.eow && checkWord(key, end + 1, memo)) {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        for(int i=0;i<wordDict.size();i++){
            insert(wordDict.get(i));
        }
        Boolean[] memo = new Boolean[s.length()];
        return checkWord(s, 0, memo);
    }
}