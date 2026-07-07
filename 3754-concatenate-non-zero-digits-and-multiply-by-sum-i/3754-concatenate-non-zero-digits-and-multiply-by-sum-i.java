class Solution {
    public long sumAndMultiply(int n) {
        int sum = 0;
        StringBuilder s = new StringBuilder();
        if(n==0){
            return 0;
        }
        while(n!=0){
            int rem = n%10;
            if(rem!=0){
                s.append(rem);
                sum+=rem;
            } 
            n = n/10;
        }
        String oriNum = s.reverse().toString();
        long x = Long.parseLong(oriNum);
        return (long) (sum*x); 
    }
}