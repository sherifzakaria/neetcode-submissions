class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int freqK[] = new int[k];
        for (int i = 0; i < k; i++) {
            int maxK = 0;
            int maxF = 0;
            for (int key : map.keySet()) {
                if (map.get(key) > maxF) {
                    maxK = key;
                    maxF = map.get(key);
                }
            }
            freqK[i] = maxK;
            map.remove(maxK);
        }

        return freqK;
    }
}
