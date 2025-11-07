class Solution {
    private long[] prefixSum;          
    private long[] differenceArray;     
    private int cityCount;              
  
    public long maxPower(int[] stations, int r, int k) {
        cityCount = stations.length;
        differenceArray = new long[cityCount + 1];
        prefixSum = new long[cityCount + 1];
      
        for (int i = 0; i < cityCount; ++i) {
            int rangeStart = Math.max(0, i - r);
            int rangeEnd = Math.min(i + r, cityCount - 1);
            differenceArray[rangeStart] += stations[i];
            differenceArray[rangeEnd + 1] -= stations[i];
        }
      
        prefixSum[0] = differenceArray[0];
        for (int i = 1; i < cityCount + 1; ++i) {
            prefixSum[i] = prefixSum[i - 1] + differenceArray[i];
        }
      
        long left = 0;
        long right = 1L << 40; 
      
        while (left < right) {
            long mid = (left + right + 1) >>> 1;  
            if (canAchieveMinPower(mid, r, k)) {
                left = mid;  
            } else {
                right = mid - 1;  
            }
        }
      
        return left;
    }
  
    /**
     * Check if we can achieve minimum power of targetMinPower for all cities
     * @param targetMinPower The target minimum power for all cities
     * @param range The range that each station can cover
     * @param additionalStations The number of additional stations we can build
     * @return true if achievable, false otherwise
     */
    private boolean canAchieveMinPower(long targetMinPower, int range, int additionalStations) {
        
        Arrays.fill(differenceArray, 0);
        long additionalPower = 0;  
       
        for (int i = 0; i < cityCount; ++i) {
            additionalPower += differenceArray[i];
            long currentPower = prefixSum[i] + additionalPower;
            long powerDeficit = targetMinPower - currentPower;
          
            if (powerDeficit > 0) {
              
                if (additionalStations < powerDeficit) {
                    return false;  
                }
              
                additionalStations -= powerDeficit;
              
               
                int optimalPosition = Math.min(i + range, cityCount - 1);
                int coverageStart = Math.max(0, optimalPosition - range);
                int coverageEnd = Math.min(optimalPosition + range, cityCount - 1);
              
                differenceArray[coverageStart] += powerDeficit;
                differenceArray[coverageEnd + 1] -= powerDeficit;
                additionalPower += powerDeficit;
            }
        }
      
        return true;
    }
}