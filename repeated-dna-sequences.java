// https://leetcode.com/problems/repeated-dna-sequences/
class Solution {
    // tc -> n, sc-> n
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new LinkedList<>();
        
        if(s==null || s.length()==0)
            return result;
        
        Map<String, Integer> freqMap = new HashMap<>();
        
        int start = 0;
        for(int i=0; i<s.length() && start+10<=s.length(); i++){
            String subStr = s.substring(start, start+10);            
            freqMap.put(subStr, freqMap.getOrDefault(subStr, 0)+1);
            start ++;;
        }
        
        
        for(String key : freqMap.keySet()){
            if(freqMap.get(key)>1){
                result.add(key);
            }
        }
        
        return result;
    }
}

class Solution {
    // tc -> n, sc-> n
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        
        if(s==null || s.length()==0)
            return new LinkedList(result);
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<=s.length()- 10; i++){
            String subStr = s.substring(i, i+10);
            
            if(set.contains(subStr))
                result.add(subStr);
            else            
                set.add(subStr);
        }
        
        return new LinkedList(result);
    }
}
