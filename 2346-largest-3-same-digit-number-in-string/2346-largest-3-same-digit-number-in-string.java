class Solution {
    public String largestGoodInteger(String num) {
        char maxDigit = 0;
        for(int i=0;i<num.length()-2;i++){
            char c = num.charAt(i);
            if(c==num.charAt(i+1) && c==num.charAt(i+2)){
                if(c>maxDigit){
                    maxDigit = c;
                }
            }
        }
        return maxDigit==0?"":""+maxDigit+maxDigit+maxDigit;
    }
}