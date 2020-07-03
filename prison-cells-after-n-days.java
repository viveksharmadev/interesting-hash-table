// https://leetcode.com/problems/prison-cells-after-n-days/
class prison-cells-after-n-days {
    /*
    As the cells have a fixed size of 8 but the first and last cell will not be updated because they do not have    
    two adjacent neighbors, we have at most 2^6 = 64 states. So regardless of input N, 
    we have both space and time complexities as O(1).
    */
    public int[] prisonAfterNDays(int[] cells, int N) {
        if(cells==null || cells.length==0 || N<=0)
            return cells;
        
        boolean hasCycle = false;
        int cycle = 0;
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<N; i++){
            int[] next = nextDay(cells);
            String key = Arrays.toString(next);
            if(!set.contains(key)){
                set.add(key);
                cycle++;
            }else{
                hasCycle = true;
                break;
            }
            cells = next;
        }
        
        if(hasCycle){
            N%=cycle;
            for(int i=0; i<N; i++)
                cells = nextDay(cells);
        }            
        
        return cells;
    }
    
    private int[] nextDay(int[] cells){
            int[] res = new int[cells.length];
            for(int i=1; i<cells.length-1; i++)
                res[i] = cells[i-1]==cells[i+1] ? 1 : 0;
            return res;
        }
}
