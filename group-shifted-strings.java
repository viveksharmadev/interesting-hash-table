// https://leetcode.com/problems/group-shifted-strings/

class Solution {
    // tc -> m*n, sc-> m*n
    public List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> result = new LinkedList<>();
        
        if(strings==null || strings.length==0) return result;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strings){
            String key = getKey(str);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(str);
        }
        
        return new LinkedList(map.values());
    }
    
    private String getKey(String str){
        StringBuilder key = new StringBuilder();
        
        char[] arr = str.toCharArray();
        
        for(int i=0; i<arr.length-1; i++){
            int diff = arr[i] - arr[i+1];
            
            diff = diff < 0 ? diff+26 : diff;
            
            key.append(diff).append(",");
        }
        
        return key.toString();
    }
}

// May be easier to understand
class Solution {
    // tc -> m*n, sc-> m*n
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result  = new LinkedList<>();
        
        if(strings==null || strings.length==0) return result;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strings){
            String key = getKey(str);
            map.putIfAbsent(key, new LinkedList<>());
            map.get(key).add(str);
        }
        
        return new LinkedList<>(map.values());
    }
    
    private String getKey(String str){
        
        StringBuilder key = new StringBuilder();
        
        for(int i=1; i<str.length(); i++){
            
            int diff = str.charAt(i) - str.charAt(i-1);
            
            key.append(diff < 0 ? diff+26 : diff);
            
            key.append(",");
        }
        
        return key.toString();
    }
}
