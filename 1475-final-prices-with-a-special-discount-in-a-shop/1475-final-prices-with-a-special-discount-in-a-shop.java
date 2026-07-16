class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && prices[i]<=prices[stack.peek()]){
                    ans[stack.peek()] =  prices[stack.peek()]-prices[i];
                    stack.pop();
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            ans[stack.peek()] = prices[stack.peek()];
            stack.pop();
        }
        return ans;
    }
}