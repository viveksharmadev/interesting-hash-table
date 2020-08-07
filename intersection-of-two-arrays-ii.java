// https://leetcode.com/problems/intersection-of-two-arrays-ii/
class Solution {
    //tc -N, sc-N
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            freqMap.put(nums1[i], freqMap.getOrDefault(nums1[i],0)+1);
        }
        
        List<Integer> res = new ArrayList<>();
        for(int j=0; j<nums2.length; j++){
            if(freqMap.containsKey(nums2[j]) 
               && freqMap.get(nums2[j])>0){
                res.add(nums2[j]);
                freqMap.put(nums2[j], freqMap.get(nums2[j])-1);
            }
        }
        
        int[] ret = new int[res.size()];
        for(int i=0; i<res.size(); i++) ret[i] = res.get(i);
        
        return ret;
    }
}

public int[] intersect(int[] nums1, int[] nums2) {
// tc -> mlogm+ nlogn, sc-> mlogm, sc-> nlogn
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i = 0, j = 0, k = 0;
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] < nums2[j]) {
            ++i;
        } else if (nums1[i] > nums2[j]) {
            ++j;
        } else {
            nums1[k++] = nums1[i++];
            ++j;
        }
    }
    return Arrays.copyOfRange(nums1, 0, k);
}
