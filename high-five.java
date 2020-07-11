// https://leetcode.com/problems/high-five/
class high-five {
    // tc -> nlogn, sc-> n
    public int[][] highFive(int[][] items) {        
        if(items==null || items.length==0)
            return items;
        
        List<int[]> res = new LinkedList<>();
                
        Map<Integer, PriorityQueue<Integer>> map 
            = new HashMap<>();
        
        for(int[] item : items){
            map.putIfAbsent(item[0], new PriorityQueue<>((a,b)-> b-a));
            //if(map.get(item[0]).size()>=5) continue;
            map.get(item[0]).offer(item[1]);            
        }
        
        for(int key : map.keySet()){
            int sum = 0, count = 0;
            PriorityQueue<Integer> pq = map.get(key);
            while(pq!=null && !pq.isEmpty() && count < 5){
                //System.out.println("key => " + key + " " + pq.peek());
                sum += pq.poll();
                count++;
            }
            res.add(new int[]{key, sum/5});            
        }       
        
        return res.toArray(new int[][]{});
    }
}
