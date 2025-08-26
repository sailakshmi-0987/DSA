class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxDiag = 0;
        int area = 0;
        int n = dimensions.length;
        for(int i=0;i<n;i++){
            int length = dimensions[i][0];
            int width = dimensions[i][1];
            double diag = Math.sqrt(length*length + width*width);
            if(diag>maxDiag){
                maxDiag = diag;
                area = length * width;
            }else if(diag==maxDiag){
                area =Math.max(area,length*width);
            }
        }
        return area;
    }
}