// https://leetcode.com/problems/verifying-an-alien-dictionary/
class Solution {
    // tc -> 1, sc-> 1
    public boolean isAlienSorted(String[] words, String order) {
        int[] map = new int[26];
        for(int i=0; i<order.length(); i++)
            map[order.charAt(i)-'a'] = i;
        
        for(int i=0; i<words.length-1; i++){
            if(words[i].equals(words[i+1])) return true;
            
            if(isFirstWordBigger(words[i], words[i+1], map)){
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isFirstWordBigger(String prevWord, String nextWord,
                                     int[] map){
        int l1 = prevWord.length(), l2 = nextWord.length();
        
        int i=0, j=0;
        
        while(i<l1 && j<l2){
            
            int diff = map[prevWord.charAt(i++)-'a'] 
                       - map[nextWord.charAt(j++)-'a'];
            
            if(diff < 0) return false;
            
            else if(diff > 0) return true;
        }
        
        return l1 >= l2;
    }
}
