class Solution {
    public boolean isPossible(int[] target) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;

        for (int num : target) {
            pq.add(num);
            sum += num;
        }

        while (true) {

            int largest = pq.poll();

            // Already reached [1,1,1,...]
            if (largest == 1) {
                return true;
            }

            long rest = sum - largest;

            // Invalid situation
            if (rest <= 0 || largest <= rest) {
                return false;
            }

            // If all other elements sum to 1,
            // we can always build the largest value.
            if (rest == 1) {
                return true;
            }

            long previous = largest % rest;

            // Cannot get back to a positive value
            if (previous == 0) {
                return false;
            }

            pq.add((int) previous);

            sum = rest + previous;
        }
    }
}