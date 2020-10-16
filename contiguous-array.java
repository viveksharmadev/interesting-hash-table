// https://leetcode.com/problems/contiguous-array/
class Solution {
    // tc -> n, sc-> n
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        
        for(int i=0; i<n; i++){
            if(nums[i]==0) nums[i] = -1;
        }
        
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);
        
        int maxLength = 0, sum = 0;
        
        for(int i=0; i<n; i++){
            sum += nums[i];
            
            if(sumIndexMap.containsKey(sum)){
                maxLength = Math.max(maxLength, i-sumIndexMap.get(sum));
            }else{
                sumIndexMap.put(sum, i);
            }
        }
        
        return maxLength;
    }
}
