class Solution {
    static class ClassInfo {
        int pass, total;
        double gain;
        ClassInfo(int p, int t) {
            pass = p;
            total = t;
            gain = calcGain();
        }
        void addStudent() {
            pass++;
            total++;
            gain = calcGain();
        }
        double ratio() {
            return (double) pass / total;
        }
        double calcGain() {
            return (double)(pass + 1) / (total + 1) - (double) pass / total;
        }
    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<ClassInfo> pq = new PriorityQueue<>((a, b) -> Double.compare(b.gain, a.gain));

        for (int[] c : classes) {
            pq.add(new ClassInfo(c[0], c[1]));
        }

        while (extraStudents-- > 0) {
            ClassInfo best = pq.poll();
            best.addStudent();
            pq.add(best);
        }

        double total = 0.0;
        for (ClassInfo ci : pq) {
            total += ci.ratio();
        }

        return total / classes.length;
    }
}