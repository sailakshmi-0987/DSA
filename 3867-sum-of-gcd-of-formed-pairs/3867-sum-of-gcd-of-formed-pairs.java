class Solution {
   public int gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mx = 0;
        for(int i=0;i<n;i++){
            mx = Math.max(nums[i],mx);
            prefixGcd[i] = gcd(nums[i],mx);
        }
        Arrays.sort(prefixGcd);
        int l=0;
        int r = n-1;
        long sum = 0;
        while(l<r){
            sum+=gcd(prefixGcd[l],prefixGcd[r]);
            l++;
            r--;
        }
        return sum;
    }
}