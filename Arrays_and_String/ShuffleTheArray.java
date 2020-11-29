/* 
Joiney Nguyen

Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

Return the array in the form [x1,y1,x2,y2,...,xn,yn].

*/

class Solution 
{
    public int[] shuffle(int[] nums, int n) 
    {
        int pointer1 = 0;
        int pointer2 = n;
        int[] output = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++)
        {
            if(i %  2 == 0)
            {
                output[i] = nums[pointer1];
                pointer1++;
            }
            else
            {
                output[i] = nums[pointer2];
                pointer2++;
            }
        }
      
        return output;
    }
}
