class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for(char c : ch){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int ans  = 0;
        boolean odd = false;
        for(Map.Entry<Character,Integer> e : map.entrySet()){
            if(e.getValue()%2==0){
                ans+=e.getValue();
            }
            else{
                ans+=(e.getValue()/2)*2;
                odd = true;
            }
                
        }
        if(odd){
            ans+=1;
        }
        return ans;
    }
}