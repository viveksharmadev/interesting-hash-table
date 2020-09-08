// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/
class SparseVector {
    // tc -> n, sc-> n
    Map<Integer, Integer> indexMap;
    
    SparseVector(int[] nums) {
        indexMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]!=0)
            indexMap.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        // Optimization
        if(indexMap.size() > vec.indexMap.size())
            return vec.dotProduct(this);
        int productSum = 0;
        for(int index : indexMap.keySet()){
            Integer val = indexMap.get(index);
            Integer currVal = vec.indexMap.get(index);
            
            if(currVal==null) continue;
            
            productSum += val*currVal;
        }
        
        return productSum;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
