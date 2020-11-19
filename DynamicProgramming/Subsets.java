/*
Joiney Nguyen

Given an integer array nums, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

*/

class Solution 
{
    public List<List<Integer>> subsets(int[] nums) 
    {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start)
    {
        result.add(new ArrayList<>(tempList));
        
        for(int i = start; i < nums.length; i++)
        {
            tempList.add(nums[i]);
            dfs(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
