import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int num : nums) {
            if (!set.add(num))
                return true;
        }
        return false;
    }
    
    public boolean mySolution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            else
                set.add(nums[i]);
        }
        return false;
    }
    
    public boolean mySolution2(int[] nums) {
        Arrays.sort(nums);
        int front = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (front == nums[i]) return true;
            else front = nums[i];
        }
        return false;
    }
}