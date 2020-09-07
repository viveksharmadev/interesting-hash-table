// https://leetcode.com/problems/word-pattern/
class Solution {
    // tc -> n, sc-> n
    public boolean wordPattern(String pattern, String str) {
        if(pattern==null || pattern.length()==0 || str==null || str.length()==0)
            return false;
        
        String[] arr = str.split(" ");
        
        if(pattern.length()!=arr.length) return false;
        
        Map<Character, String> map = new HashMap<>();        
        
        Set<String> visited = new HashSet<>();
        
        for(int i=0; i<pattern.length(); i++){            
            char patternChar = pattern.charAt(i);
                    
            if(map.containsKey(patternChar)){
               if(!arr[i].equals(map.get(patternChar)))
                return false;
            }else{            
                if(visited.contains(arr[i])) return false;
                visited.add(arr[i]);
                map.put(patternChar, arr[i]);
            }
        }
        
        return true;
    }
}
