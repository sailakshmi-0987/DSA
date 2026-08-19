class Solution {
    public boolean detectCapitalUse(String word) {
        int uppercasecount = 0;
        for(char ch : word.toCharArray()){
            if(Character.isUpperCase(ch)){
                uppercasecount++;
            }
        }

        return uppercasecount==0 || uppercasecount==word.length() || 
                (uppercasecount==1 && Character.isUpperCase(word.charAt(0)));
    }
}