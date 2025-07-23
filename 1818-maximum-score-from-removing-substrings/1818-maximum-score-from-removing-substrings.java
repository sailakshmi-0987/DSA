class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return gain(s, 'a', 'b', x, y); 
        } else {
            return gain(s, 'b', 'a', y, x); 
        }
    }

    public int gain(String s, char first, char second, int high, int low) {
        int score = 0;
        Stack<Character> stack = new Stack<>();

       
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && s.charAt(i) == second && stack.peek() == first) {
                stack.pop();
                score += high;
            } else {
                stack.push(s.charAt(i));
            }
        }

       
        StringBuilder remaining = new StringBuilder();
        for (char c : stack) {
            remaining.append(c);
        }

        
        stack.clear();
        for (int i = 0; i < remaining.length(); i++) {
            char ch = remaining.charAt(i);
            if (!stack.isEmpty() && ch == first && stack.peek() == second) {
                stack.pop();
                score += low;
            } else {
                stack.push(ch);
            }
        }

        return score;
    }
}