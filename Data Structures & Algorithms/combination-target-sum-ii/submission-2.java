class Solution {
    List<List<Integer>> result;
    private void combinationSum(int[] nums, int target, int i, List<Integer> list){
        if(target== 0){
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        if(i>=nums.length) return;
        //exclude the element and it's duplicates
        int next = i+1;
        while(next<nums.length && nums[next] == nums[i]) next++;
        combinationSum(nums,target,next,list);
        //include the element only if the target is not getting negative after including
        if(target-nums[i] >= 0){
            list.add(nums[i]);
            combinationSum(nums,target-nums[i],i+1,list);
            list.remove(list.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();

        for(int i =0;i<candidates.length;i++){
            if(i==0 && target-candidates[i] >=0){
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                combinationSum(candidates,target-candidates[i],i+1,list);
            }
            else if(i>0 && candidates[i] != candidates[i-1] && target-candidates[i] >=0){
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                combinationSum(candidates,target-candidates[i],i+1,list);
            }
        }
        return result;
    }
}
