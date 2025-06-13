# Two Sum Solution
### Optimizing the Two Sum Problem with HashMap
To solve the Two Sum problem efficiently, one may first consider a brute-force approach with a time complexity of O(n²). While this method checks all possible pairs to find the solution, it is inefficient for large datasets.

However, the problem provides two important insights:

There is exactly one solution.

If a number x exists in the array, the complement to reach the target is target - x.

Given this, we can improve the solution using a HashMap for constant-time lookups.

_____

### Initial Approach
My first attempt involved two passes through the array:
1. Create a HashMap where each key is the number and the corresponding value is its index.
2. Iterate again to check if the complement (target - nums[i]) exists in the map and ensure it is not the same index.

A concern here was the possibility of duplicate numbers in the array. However, due to the constraint that there is only one valid solution, the following applies:
- If the solution involves the same number twice (e.g., x + x = target), the map will store only the last index due to overwriting. The first loop will still find the first occurrence, and the second loop will use the stored second occurrence.
- If the duplicate numbers are not part of the solution, this setup still works without issue.

This method yields a runtime of 4 ms, which is acceptable, but it can be optimized further.
```java
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
```
Optimized One-Pass Solution
After reviewing the official LeetCode explanation, I implemented an even more efficient solution by integrating the insertion and lookup processes into a single pass. This avoids unnecessary upfront work and leverages early termination when the solution is found.

In this version:
- For each element, we immediately check if its complement exists in the map.
- If not, we insert the current element into the map and continue.

This ensures O(n) time complexity with a single traversal and no extra post-processing.

```java
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
```
