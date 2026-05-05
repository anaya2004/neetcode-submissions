class Solution {
    List<List<Integer>> result;
    private void combinationSum(int[] nums, int target, int i, List<Integer> list){
        if(target== 0){
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        if(i>=nums.length) return;
        //exclude the element
        combinationSum(nums,target,i+1,list);
        //include the element only if the target is not getting negative after including
        if(target-nums[i] >= 0){
            list.add(nums[i]);
            combinationSum(nums,target-nums[i],i,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        combinationSum(nums,target,0,new ArrayList<>());
        return result;
    }
}
