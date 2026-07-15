class Solution {
    public List<String> buildArray(int[] target, int n) {
        Stack<Integer> stack = new Stack<>();
        int m = target.length;
        int j = 0;
        List<String> ans = new ArrayList<>();
        for(int i=1;i<=n;i++){
            stack.push(i);
            ans.add("Push");
            if(target[j]==stack.peek()){
                j++;
            }
            else{
                ans.add("Pop");
                stack.pop();
            }
            if(j==target.length){
                break;
            }
            
        }
        return ans;
    }
}