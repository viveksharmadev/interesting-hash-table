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
