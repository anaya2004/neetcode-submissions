class Solution {
    List<List<Integer>> result;
    private void subsets(int[] nums, List<Integer> list, int i){
        if(i>=nums.length){
            //copy the current list in new list and add it to the result list
            List<Integer> temp = new ArrayList<>(list);
            result.add(temp);
            return;
        }
        //exclude the current element
        subsets(nums,list,i+1);
        //include the current element
        list.add(nums[i]);
        subsets(nums,list,i+1);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        subsets(nums,new ArrayList<>(),0);
        return result;
    }
}
