// https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/
class Solution {
    // tc -> n, sc-> n
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        
        int sum = 0, count = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - target))
                count = Math.max(count, map.get(sum-target)+1);
            map.put(sum, count);            
        }
        
        return count;
    }
}
