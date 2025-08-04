class Solution {
    public int lastStoneWeightII(int[] stones) {
        int totalWeight =0;
        for(int weight : stones){
            totalWeight+=weight;
        }
        int target = totalWeight/2;
        int[] dp = new int[target+1];
        Arrays.fill(dp,0);
        for(int weight : stones){
            for(int j=target;j>=weight;j--){
                dp[j]=Math.max(dp[j],dp[j-weight]+weight);
            }
        }
        return totalWeight - dp[target]*2;
    }
}