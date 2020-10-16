// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
class Solution {
    // tc -> n, sc-> n
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        
        int maxLength = 0;
       
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0,-1);
        
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += nums[i];
            
            if(sumIndexMap.containsKey(sum-k)){
                maxLength = Math.max(maxLength, i-sumIndexMap.get(sum-k));
            }
            
            if(!sumIndexMap.containsKey(sum)){
                sumIndexMap.put(sum, i);
            }
        }
       
        
        return maxLength;
    }
}
