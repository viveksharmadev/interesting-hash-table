// https://leetcode.com/problems/continuous-subarray-sum/
class Solution {
    // tc -> n, sc-> n
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        
        sumIndexMap.put(0, -1);
        
        int n = nums.length;
        
        int sum = 0;
        
        for(int i=0; i<n; i++){
            sum += nums[i];
            
            if(k!=0) sum %= k;
            
            if(sumIndexMap.containsKey(sum)){
                if(i-sumIndexMap.get(sum) > 1)
                    return true;
            }
            
            else{
                sumIndexMap.put(sum, i);
            }
        }
        
        return false;
    }
}
