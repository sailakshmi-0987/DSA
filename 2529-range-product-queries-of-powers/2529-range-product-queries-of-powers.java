class Solution {
    private static final int MOD = 1000000007;
    public int[] productQueries(int n, int[][] queries) {
        List<Integer>  bins = new ArrayList<>();
        int rep =1;
        while(n>0){
            if(n%2==1){
                bins.add(rep);
            }
            n/=2;
            rep*=2;
        }
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++){
            long curr =1;
            int start = queries[i][0];
            int end = queries[i][1];

            for(int j=start;j<=end;j++){
                curr = (curr*bins.get(j))%MOD;
            }
            ans[i]=(int)curr;
        }
        return ans;
    }
}