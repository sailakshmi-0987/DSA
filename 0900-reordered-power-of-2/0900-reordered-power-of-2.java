class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        Arrays.sort(digits); // sort to help skip duplicates
        boolean[] used = new boolean[digits.length];
        return backtrack(digits, used, 0, 0);
    }
        private boolean backtrack(char[] digits, boolean[] used, int index, long num) {
        if (index == digits.length) {
            return isPowerOfTwo(num);
        }
        
        for (int i = 0; i < digits.length; i++) {
        
            if (used[i]) continue;
          
            if (index == 0 && digits[i] == '0') continue;
            
            if (i > 0 && digits[i] == digits[i - 1] && !used[i - 1]) continue;
            
            used[i] = true;
            if (backtrack(digits, used, index + 1, num * 10 + (digits[i] - '0'))) {
                return true;
            }
            used[i] = false;
        }
        
        return false;
    }
    
    private boolean isPowerOfTwo(long num) {
        return (num & (num - 1)) == 0;
    }
}