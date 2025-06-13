import java.util.HashMap;

public class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer index = hash.get(target - nums[i]);
            if (index != null && index != i) {
                return new int[] { i, index };
            }
            hash.put(nums[i], i);
        }
        
        return new int[0];
    }
    
    public int[] mySolution(int[] nums, int target) {
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer> ();
        for (int i = 0; i < nums.length; i++){
            hash.put(nums[i], i);
        }
        for (int i = 0; i < nums.length-1; i++){
            Integer index = hash.get(target-nums[i]);
            if (index != null && index != i){
                return new int[]{i, index};
            }
        }
        return new int[0];
    }
}
