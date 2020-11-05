// https://leetcode.com/problems/make-two-arrays-equal-by-reversing-sub-arrays/
class Solution {
    // tc -> n, sc-> n
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0)+1);
            freqMap.put(target[i], freqMap.getOrDefault(target[i], 0)-1);
        }
        
        for(int key : freqMap.keySet()){
            if(freqMap.get(key)!=0) return false;
        }
        
        return true;
    }
}
