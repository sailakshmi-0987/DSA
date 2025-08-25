class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m*n];
        int idx =0;
        for(int d=0;d<m+n-1;d++){
            int r,c;
            if(d%2==0){
                r = d<m?d:m-1;
                 c = d - r;
                while (r >= 0 && c < n) {
                    result[idx++] = mat[r][c];
                    r--;
                    c++;
                }
            }else{
                c = d<n?d:n-1;
                r = d - c;
                while (c >= 0 && r < m) {
                    result[idx++] = mat[r][c];
                    r++;
                    c--;
                }
            }
        }
        return result;
    }
}