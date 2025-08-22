class Solution {
    public int minimumArea(int[][] grid) {
        int area;
        int m = grid.length,n=grid[0].length;
        int minRow=m,maxRow=-1;
        int minCol=n,maxCol=-1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    minRow = Math.min(minRow,i);
                    maxRow = Math.max(maxRow,i);
                    minCol = Math.min(minCol,j);
                    maxCol = Math.max(maxCol,j);
                }
            }
        }
        if(maxCol == -1) return 0;
        int height = maxRow - minRow+1;
        int width = maxCol - minCol+1;
        area = height*width;

        return area;
    }
}