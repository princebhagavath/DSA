class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int comp = target - nums[i];
            if (hm.containsKey(comp))
                return new int[] { hm.get(comp), i };
            hm.put(nums[i], i);
        }
        return null;
    }
}