/*
Joiney Nguyen

Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
*/


class NumArray 
{
    int[] array;
        
    public NumArray(int[] nums) 
    {
        array = new int[nums.length];
        array = nums.clone();
    }
    
    public int sumRange(int i, int j) 
    {
        int sums = 0;
        
        for(int index = i; index <= j; index++)
        {
            sums = sums + array[index];
        }
        
        return sums;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
