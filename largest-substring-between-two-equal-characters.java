// https://leetcode.com/problems/largest-substring-between-two-equal-characters/
class Solution {
    // tc -> n, sc-> n
    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        
        
        int maxLength = -1;
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if(indexMap.containsKey(c)){
                maxLength = Math.max(maxLength, i - indexMap.get(c) - 1);        
            }else{
                indexMap.put(c, i);
            }
        }
        
        return maxLength;
    }
}
