/*
Joiney Nguyen

Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.

*/

class Solution 
{
    public int numIdenticalPairs(int[] nums) 
    {
        int count = 0;
        
        for(int i = 0; i < nums.length - 1; i++)
        {
            for(int j = i + 1; j < nums.length; j++)
            {
                if(nums[i] == nums[j])
                {
                    count++;
                }
            }
        }
        
        return count;
    }
}
