class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    static boolean solve(char[][] board){
        int n=board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    emptyLeft = false;
                    break;
                }
            }
            if(emptyLeft==false){
                break;
            }
        }
        if(emptyLeft==true){
            return true;
        }
        for(char c='1';c<='9';c++){
            if(isSafe(board,row,col,c)){
                board[row][col]=c;
                if(solve(board)){
                    return true;
                }else{
                    board[row][col]='.';
                }
            }
        }
        return false;
    }
    static boolean isSafe(char[][] board,int row,int col,char num){
        for(int i=0;i<board.length;i++){
            if(board[row][i]==num){
                return false;
            }
        }
        for(char[] nums:board){
            if(nums[col]==num){
                return false;
            }
        }
        int sqrt = (int)(Math.sqrt(board.length));
        int start = row - row%sqrt;
        int end = col - col%sqrt;

        for(int r = start;r<start+sqrt;r++){
            for(int c=end;c<end+sqrt;c++){
                if(board[r][c]==num){
                    return false;
                }
         
           }
        }
        return true;
    }
}