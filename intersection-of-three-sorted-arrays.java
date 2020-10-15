// https://leetcode.com/problems/intersection-of-three-sorted-arrays/
class Solution {
    // tc -> l+m+n(in worst case), sc-> common numbers of three arrays(k)
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int i=0, j=0, k=0;
        
        List<Integer> result = new LinkedList<>();
        
        while(i<arr1.length && j<arr2.length && k<arr3.length){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                result.add(arr1[i]);
                i++; j++; k++;
            }else if(arr1[i] < arr2[j]){
                i++;
            }else if(arr2[j] < arr3[k]){
                j++;
            }else{
                k++;
            }
        }
        
        return result;
    }
}
