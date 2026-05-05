class Solution {
    private List<Integer> subsetXORSumHelper(int[] nums, int i){
        if(i >= nums.length-1){
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            ans.add(nums[i]);
            return ans;
        }
        List<Integer> temp = subsetXORSumHelper(nums,i+1);
        int n = temp.size();
        for(int j=0;j<n;j++){
            System.out.println(nums[i] + ":" + temp.get(j));
            temp.add(temp.get(j)^nums[i]);
        }
        return temp;
    }
    public int subsetXORSum(int[] nums) {
        List<Integer> xor = subsetXORSumHelper(nums,0);
        int sum = 0;
        for(int i =0;i<xor.size();i++){
            sum += xor.get(i);
        }
        return sum;
    }
}