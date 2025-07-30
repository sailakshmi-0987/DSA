class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1]; 
        for(int i =1;i<n;i++){
                temp1[i-1]=nums[i];
            
        }
         for(int i =0;i<n-1;i++){
            temp2[i]=nums[i];
        }
        return Math.max(maxAmount(temp1),maxAmount(temp2));
    }
    public int maxAmount(int[] nums){
        int n = nums.length;
        if(n==1){
            return nums[n-1];
        }
        int prev2=0;
        int prev = nums[0];
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1)pick+=prev2;
            int notpick = 0+prev;

            int curr=Math.max(pick,notpick);
            prev2=prev;
            prev=curr;
        }
        return prev;
    }
}