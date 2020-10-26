// https://leetcode.com/problems/longest-consecutive-sequence/
class Solution {
    //tc - N, sc - N
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0, max= 0;
        for(int num : nums){
            if(!map.containsKey(num)){
                int left = map.getOrDefault(num-1, 0);
                int right = map.getOrDefault(num+1, 0);
                int sum = left + right + 1;
                res = Math.max(res, sum);
                map.put(num, sum);
                map.put(num-left, sum);
                map.put(num+right, sum);
            }else continue;
        }
        return res;
    }
}
