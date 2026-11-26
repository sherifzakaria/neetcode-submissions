class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsList = new ArrayList<>();
        dfsHelper(nums, 0, subsetsList, new ArrayList<>());
        return subsetsList;
    }

    private void dfsHelper(
        int[] nums, int idx, List<List<Integer>> subsetsList, List<Integer> subset) {
        if (idx >= nums.length) {
            subsetsList.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[idx]);
        dfsHelper(nums, idx + 1, subsetsList, subset);

        subset.removeLast();
        dfsHelper(nums, idx + 1, subsetsList, subset);
    }
}
