class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map1 = new HashMap<>();
        HashMap<Character,Integer> map2 = new HashMap<>();
        int vowelFreq = 0;
        int consonantFreq = 0 ;
        for(char ch : s.toCharArray()){
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.get(ch)>=vowelFreq){
                    vowelFreq = map1.get(ch);
                }
            }else{
                map2.put(ch,map2.getOrDefault(ch,0)+1);
                if(map2.get(ch)>=consonantFreq){
                    consonantFreq = map2.get(ch);
                }
            }
        }
        int sum = 0;
        sum = vowelFreq+consonantFreq;

        return sum;
    }
}