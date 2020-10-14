// https://leetcode.com/problems/find-the-difference/

class Solution {
    // tc -> n, sc-> 1
    public char findTheDifference(String s, String t) {
        int[] map = new int[26];
        
        for(int i=0; i<s.length(); i++){
            map[s.charAt(i)-'a']++;
        }
        
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            map[c-'a']--;
            if(map[c-'a'] < 0) return c;
        }
        
        return ' ';
    }
}

class Solution {
    // tc -> n, sc-> n
    public char findTheDifference(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        
        for(int i=0; i<t.length(); i++){
            char c = t.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0)+1);
        }
        
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(freqMap.containsKey(c)){
                freqMap.put(c, freqMap.get(c)-1);
            }
        }
        
        for(char key : freqMap.keySet()){
            if(freqMap.get(key)==1)
                return key;
        }
        
        return ' ';
    }
}

class Solution {
    // tc -> n, sc-> 1
    public char findTheDifference(String s, String t) {
        char c = 0;
        
        for(int i=0; i<s.length(); i++){
            c ^= s.charAt(i);
        }
        
        for(int i=0; i<t.length(); i++){
            c ^= t.charAt(i);
        }
        
        return c;
    }
}
