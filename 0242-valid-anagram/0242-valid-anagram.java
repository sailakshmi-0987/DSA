class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        HashMap<Character,Integer> h1 = new HashMap<>();
        HashMap<Character,Integer> h2 = new HashMap<>();
        boolean ans = false;
        for(char c : s1){
            h1.put(c,h1.getOrDefault(c,0)+1);
        }
        for(char c : t1){
            h2.put(c,h2.getOrDefault(c,0)+1);
        }
        for(int i = 0 ; i<t1.length;i++){
            if(!h1.containsKey(t1[i])){
                return false;
            }else{
                if(h1.get(t1[i]).equals(h2.get(t1[i]))){
                    ans = true;
                }else{
                    return false;
                }
            }
        }
        return ans;
    }
}