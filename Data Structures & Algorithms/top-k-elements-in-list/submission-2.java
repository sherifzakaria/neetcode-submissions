class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i : nums) {
            freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(entry.getKey());
        }

        int[] result = new int[k];
        int idx = 0;
        for (int i = bucket.length - 1; i >= 0 && k > 0; i--) {
            if (bucket[i] != null && !bucket[i].isEmpty()) {
                for (int num : bucket[i]) {
                    result[idx++] = num;
                    k--;
                    if (k == 0) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
