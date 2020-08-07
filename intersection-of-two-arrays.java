// https://leetcode.com/problems/intersection-of-two-arrays/
class Solution {
// tc -> m+n, sc-> m+n
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums1) set.add(num);
        
        Set<Integer> intersect = new HashSet<>();
        for(int num : nums2){
            if(set.contains(num)) intersect.add(num);
        }
        int[] res = new int[intersect.size()];
        int j=0;
        for(int i: intersect) res[j++] = i;
        return res;
    }
}

class Solution {
    // tc -> nlogn, sc-> n
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int i=0, j=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else{
                set.add(nums1[i]);
                i++; j++;
            }
        }
        int[] res = new int[set.size()];
        int k=0;
        for(int s : set){
            res[k++] = s;
        }
        return res;
    }
}
