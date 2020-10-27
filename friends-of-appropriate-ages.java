// https://leetcode.com/problems/friends-of-appropriate-ages/
// Brute Force
class Solution {
    // tc -> n^2, sc-> 1
    public int numFriendRequests(int[] ages) {
        int count = 0;
        
        for(int i=0; i<ages.length; i++){
            
            for(int j=i+1; j<ages.length; j++){
                
                if(canMakeFrndReq(ages[i], ages[j])){
                    count++;
                }

                if(canMakeFrndReq(ages[j], ages[i])){
                    count++;
                }
                
            }
        }
        
        return count;
    }
    
    private boolean canMakeFrndReq(int ageA, int ageB){
        return !(ageB <= (.5*ageA + 7) 
                 || ageB > ageA
                 || (ageB > 100 && ageA < 100));
    }
}

// Using Map
class Solution {
    // tc -> A(age length)^2 + N(max 120), sc-> A(ages)
    public int numFriendRequests(int[] ages) {
        Map<Integer, Integer> countMap 
            = new HashMap<>();
        
        // Age can be max 120
        for(int age : ages)
            countMap.put(age, countMap.getOrDefault(age,0)+1);
        
        int result = 0;
        
        for(int a : countMap.keySet()){            
            for(int b : countMap.keySet()){
                
                if(canMakeFrndReq(a, b)){
                    result += countMap.get(a) 
                              * (countMap.get(b) 
                                - (a==b ? 1 : 0));
                              
                }
            }
        }
        
        return result;
    }
    
    private boolean canMakeFrndReq(int ageA, int ageB){
        return !(ageB <= (.5*ageA + 7) 
                 || ageB > ageA
                 || (ageB > 100 && ageA < 100));
    }
}
