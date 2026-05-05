class Solution {
    int sum = 0;
    private void subsetXORSum(int[] nums, int xor,int i){
        if(i>=nums.length){
            sum += xor;
            return;
        }
        //exclude the current element
        subsetXORSum(nums,xor,i+1);
        //incluse the current element
        subsetXORSum(nums, xor^nums[i], i+1);
    }
    public int subsetXORSum(int[] nums) {
        sum = 0;
        subsetXORSum(nums,0,0);
        return sum;
    }
}