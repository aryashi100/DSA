class Solution {
    int prefix[];
    Random random = new Random();
    public Solution(int[] w) {
        prefix = new int[w.length];
        prefix[0]=w[0];
        for(int i =1;i<w.length;i++){
            prefix[i]=prefix[i-1]+w[i];
        }
    }
    
    public int pickIndex() {
       int total = prefix[prefix.length-1];
       int target = random.nextInt(total)+1;
       for(int i =0 ;i<prefix.length;i++){
        if(target<=prefix[i]){
            return i;
        }
       }
       return -1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */