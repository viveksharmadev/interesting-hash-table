// https://leetcode.com/problems/fraction-to-recurring-decimal/
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
//tc -> The time com should be O (denominator), cause the mod must be less than denominator. so you can run from 1 to mod times

//sc -1
        if(numerator==0) return "0";
        StringBuilder res = new StringBuilder();

        // + or -
        res.append(((numerator>0)^(denominator>0)) ?"-":"");
        
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // Integral
        res.append(num/den);
        num%=den;
        if(num==0) return res.toString();
        
        //Fractional
        res.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, res.length());
        while(num!=0){
            num*=10;
            res.append(num/den);
            num%=den;
            if(map.containsKey(num)){
                int index = map.get(num);
                res.insert(index, "(");
                res.append(")");
                break;
            }else{
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}

// May be easier to understand
class Solution {
    // tc -> n, sc-> n
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) return "0";
        
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        
        String sign = (numerator < 0 ^ denominator < 0) 
                      ? "-" : "";
        
        StringBuilder result = new StringBuilder();
        result.append(sign);        
        result.append(num/den);
        
        long rem = num%den;
        
        if(rem==0) return result.toString();
        
        result.append(".");
        
        Map<Long, Integer> map = new HashMap<>();
        
        while(rem != 0){
            
            if(map.containsKey(rem)){
                int index = map.get(rem);
                return result.substring(0, index) 
                    + "("  + result.substring(index) + ")";
            }
            
            else{
                map.put(rem, result.length());
            }
            
            rem *= 10;
            result.append(rem/den);
            rem %= den;            
        }
        
        return result.toString();
    }
}
