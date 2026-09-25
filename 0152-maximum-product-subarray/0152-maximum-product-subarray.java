class Solution {
    public int maxProduct(int[] nums) {
       int maxP = nums[0];
       int minP = nums[0];
       int answer = nums[0];
       for(int i = 1 ;i<nums.length ;i++){
        int num=nums[i];
        int oldmax = maxP;
        int oldmin = minP;
        maxP = Math.max(num,Math.max(num*oldmax,num*oldmin));
        minP = Math.min(num,Math.min(num*oldmax,num*oldmin));
        answer = Math.max(answer,maxP);
       }
       return answer ;
    }
}