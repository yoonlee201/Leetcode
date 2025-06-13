import java.util.HashMap;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++){
            Integer value = hash.get(nums[i]);
            if (value != null && i - value <= k) return true;
            else hash.put(nums[i], i);
        }

        return false;
    }
}