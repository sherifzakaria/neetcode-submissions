class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> stack = new ArrayDeque<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek()[1] < temperatures[i]) {
                int[] peek = stack.pop();
                int idx = peek[0];
                int temp = peek[1];
                res[idx] = i - idx;
            }
            stack.push(new int[] {i, temperatures[i]});
        }
        return res;
    }
}
