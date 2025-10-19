class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String smallest = s;
        
        queue.offer(s);
        visited.add(s);
        
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }
            
            char[] chars = curr.toCharArray();
            for (int i = 1; i < chars.length; i += 2) {
                chars[i] = (char) ((chars[i] - '0' + a) % 10 + '0');
            }
            String added = new String(chars);
            int n = curr.length();
            String rotated = curr.substring(n - b) + curr.substring(0, n - b);
            if (visited.add(added)) queue.offer(added);
            if (visited.add(rotated)) queue.offer(rotated);
        }
        
        return smallest;
    }
}