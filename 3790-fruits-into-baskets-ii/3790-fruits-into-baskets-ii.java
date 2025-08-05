class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int m = fruits.length;
        int n = baskets.length;
        if(m!=n){
            return 0;
        }
        int count = m;
        boolean[] vis = new boolean[n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[j]){
                    if(fruits[i]<=baskets[j]){
                        count--;
                        vis[j]=true;
                        break;
                    }
                }
            }
        }
        return count;
    }
}