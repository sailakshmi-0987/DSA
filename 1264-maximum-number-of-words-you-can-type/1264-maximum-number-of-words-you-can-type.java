class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        int  num = 0;
        for(char c : brokenLetters.toCharArray()){
            set.add(c);
        }
        String[] str = text.split("\\s+");
        for(int i=0;i<str.length;i++){
            String s = str[i];
            boolean count = true;
            for(char ch : s.toCharArray()){
                if(set.contains(ch)){
                    count = false;
                    break;
                }
            }
            if(count){
                num = num+1;
            }
        }
        return num;
    }
}