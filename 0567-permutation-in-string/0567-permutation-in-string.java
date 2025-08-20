class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int k = s1.length();
        Map<Character,Integer> map1 = new HashMap<>();
        for(char c : s1.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        Map<Character,Integer> map2 = new HashMap<>();
        for(int i=0;i<k;i++){
            char c = s2.charAt(i);
            map2.put(c,map2.getOrDefault(c,0)+1);
        }
        if(map1.equals(map2)) return true;
        for(int i =k;i<s2.length();i++){
            char old = s2.charAt(i-k) ;
            char newChar = s2.charAt(i);

            map2.put(newChar,map2.getOrDefault(newChar,0)+1);
            map2.put(old,map2.get(old)-1);
            if(map2.get(old)==0){
                map2.remove(old);
            }
            if (map1.equals(map2)) return true;
        }
        return false;
    }
}