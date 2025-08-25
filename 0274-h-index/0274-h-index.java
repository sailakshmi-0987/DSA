class Solution {
    private boolean hasHindex(int h,int[] citations){
        int count =0;
        for(int citi : citations){
            if(citi>=h){
                count+=1;
            }
        }
        return count>=h;
    }
    public int hIndex(int[] citations) {
        int low = 0;
        int high = citations.length;
        while(low<=high){
            int mid = (low+high)/2;
            if(hasHindex(mid,citations)){
                low=low+1;
            }
            else{
                high = high -1;
            }
        }
        return high;
    }
}