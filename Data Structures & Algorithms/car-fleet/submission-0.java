class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pairs = new int[position.length][2];

        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> a[0] - b[0]);

        Deque<Double> stack = new ArrayDeque<>();

        for (int i = pairs.length - 1; i >= 0; i--) {
            int pos = pairs[i][0];
            int spd = pairs[i][1];
            double timeToDest = (double) (target - pos) / spd;
            if (stack.isEmpty() || stack.peek() < timeToDest) {
                stack.push(timeToDest);
            }
        }

        return stack.size();
    }
}
