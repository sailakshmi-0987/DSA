class Solution {
    public boolean isValid(String word) {
        if(word.length()<3){
            return false;
        }
        boolean hasVowel = false;
        boolean hasConsonant = false;
        for(int i=0;i<word.length();i++){
            if(!Character.isLetterOrDigit(word.charAt(i))){
                return false;
            }
            if(isVowel(word.charAt(i))){
                hasVowel = true;
            }
           else if(Character.isLetter(word.charAt(i))){
            hasConsonant = true;
           }
        }
        return hasVowel && hasConsonant;
    }
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}