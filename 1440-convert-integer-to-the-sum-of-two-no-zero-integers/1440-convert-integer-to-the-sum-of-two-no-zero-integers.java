class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i =1;i<n;i++){
            int A = i;
            int B = n-i;
            if(isNoZero(A) && isNoZero(B)){
                return new int[]{A,B};
            }
        }
        return new int[]{0};
    }
    public boolean isNoZero(int num){
        while(num>0){
            if(num%10==0){
                return false;
            }
            num = num/10;
        }
        return true;
    }
}