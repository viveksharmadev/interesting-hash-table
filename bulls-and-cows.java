// https://leetcode.com/problems/bulls-and-cows/
class Solution {
    // tc -> n, sc-> 1
    public String getHint(String secret, String guess) {
        
        int[] map = new int[10];
        
        int bulls = 0, cows = 0;
        for(int i=0; i<secret.length(); i++){
            
            if(secret.charAt(i)==guess.charAt(i)){
                bulls++;
            }else{
                if(map[secret.charAt(i)-'0']++ < 0) cows++;;
                if(map[guess.charAt(i)-'0']-- > 0) cows++;
            }
            
        }
        
        return bulls + "A" + cows + "B";
    }
}
