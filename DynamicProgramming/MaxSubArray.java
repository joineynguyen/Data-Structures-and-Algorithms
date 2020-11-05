/*
Joiney Nguyen

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/

class Solution {
    public int maxSubArray(int[] nums) 
    {
        if(nums.length == 0)
        {
            return 0;
        }
        
        if(nums.length == 1)
        {
            return nums[0];
        }
        
        int maxSum = nums[0];
        int currentSum = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            
            maxSum = Math.max(maxSum, currentSum);
            
        }
        
        
        return maxSum;
    }
}
