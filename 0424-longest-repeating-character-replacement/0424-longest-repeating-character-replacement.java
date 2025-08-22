class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int maxlen=0,maxFreq=0;
        int left = 0;
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            maxFreq = Math.max(maxFreq,map.get(s.charAt(right)));
            while(right-left+1-maxFreq>k){
                 map.put(s.charAt(left),map.get(s.charAt(left))-1);
                 left++;
            }
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}