class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        if(arr[0]!=1){
            arr[0] = 1;
        }
        for(int i = 1 ; i<n ; i++){
            if(arr[i]-arr[i-1]>1){
                arr[i] = arr[i-1]+1;
            }
        }
        int ans = 0;
        for(int i = 0 ; i< n;i++){
            if(arr[i]>ans){
                ans = arr[i];
            }
        }
        return ans;
    }
}