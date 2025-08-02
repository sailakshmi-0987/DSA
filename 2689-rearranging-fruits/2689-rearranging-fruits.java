class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int num : basket1){
            map.put(num,map.getOrDefault(num,0)+1);
            min = Math.min(num,min);
        }
        for(int num1:basket2){
            map.put(num1,map.getOrDefault(num1,0)-1);
            min = Math.min(num1,min);
        }
        List<Integer> merge = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int count = entry.getValue();
            if(count%2!=0)return -1;
            for(int i=0;i<Math.abs(count)/2;i++){
                merge.add(entry.getKey());
            }
        }
        Collections.sort(merge);
        long res = 0;
        for(int i=0;i<merge.size()/2;i++){
            res+=Math.min(2*min,merge.get(i));
        }
        return res;
    }
}