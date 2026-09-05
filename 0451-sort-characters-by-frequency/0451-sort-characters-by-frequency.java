class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Character> pq = new PriorityQueue<>(
        (a,b)-> map.get(b)-map.get(a)
        );
        pq.addAll(map.keySet());

        StringBuilder result = new  StringBuilder();

        while(!pq.isEmpty()){
            char ch = pq.poll();
            int frequency = map.get(ch);
             for (int i = 0; i < frequency; i++) {
                result.append(ch);
            }
        }
        return result.toString();
    }
}