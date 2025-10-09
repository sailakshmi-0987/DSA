class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length, m = mana.length;
        long[] end = new long[n]; 
        for (int j = 0; j < m; j++) {
            long maxNeed = Long.MIN_VALUE;
            long prefix = 0L;
            for (int i = 0; i < n; i++) {
                long t = (long) skill[i] * (long) mana[j];
                long need = end[i] - prefix; 
                if (need > maxNeed) maxNeed = need;
                prefix += t;
            }
            long s = Math.max(maxNeed, 0L);
            prefix = 0L;
            for (int i = 0; i < n; i++) {
                long t = (long) skill[i] * (long) mana[j];
                prefix += t;
                end[i] = s + prefix;
            }
        }
        return end[n - 1];
    }
}
