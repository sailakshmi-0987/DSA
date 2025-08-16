class Solution {
    public int maximum69Number (int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for(int i=0;i<str.length();i++){
            digits[i]=str.charAt(i)-'0';
        }
        for(int i=0;i<str.length();i++){
            if(digits[i]==9){
                continue;
            }
            if(digits[i]==6){
                digits[i]=9;
                break;
            }

        }
        int n = 0;
        for (int d : digits) {
            n = n * 10 + d;
        }
        return n;
    }
}