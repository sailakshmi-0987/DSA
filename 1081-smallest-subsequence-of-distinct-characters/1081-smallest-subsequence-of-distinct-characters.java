class Solution {
    public String smallestSubsequence(String s) {
        int[] lastindex = new int[26];
        for(int i=0;i<s.length();i++){
            lastindex[s.charAt(i)-'a']=i;
        }
        boolean[] seen = new boolean[26];
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int idx = c - 'a';

            if(seen[idx])continue;
             while (!stack.isEmpty() && c < stack.peek() && lastindex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            seen[idx] = true;
        }
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}