class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length*grid[0].length;
        int[] arr = new int[n];
        int index = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                arr[index++] = grid[i][j];
            }
        }
        k = k%n;
        reverse(arr,0,n-1);
        reverse(arr,0,k-1);
        reverse(arr,k,n-1);

        List<List<Integer>> ans = new ArrayList<>();
        index = 0;
        for(int i=0;i<grid.length;i++){
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<grid[0].length;j++){
                curr.add(arr[index++]);
            }
            ans.add(curr);
        }
        return ans;
    }
    private static void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}