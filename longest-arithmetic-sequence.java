// https://leetcode.com/problems/longest-arithmetic-sequence/
class Solution {
    // tc -> n, sc-> n
    public int longestArithSeqLength(int[] A) {
        int res = 1, n = A.length;
        Map<Integer, Integer>[] map = new HashMap[n];
        for(int i=0; i<n; i++){
            map[i] = new HashMap<>();
            for(int j=0; j<i; j++){
                int diff = A[i]-A[j];
                map[i].put(diff, map[j].getOrDefault(diff, 1)+1);                         res = Math.max(res, map[i].get(diff));
            }
        }
        return res;
    }
}
