class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for(int j=0;j<=i;j++){
                row.add(1);
            }
            for(int j=1;j<i;j++){
                int left = ans.get(i-1).get(j-1);
                int right = ans.get(i-1).get(j);
                int sum = left+right;
                row.set(j,sum);
            }
            ans.add(row);
        }
        return ans;
    }
}