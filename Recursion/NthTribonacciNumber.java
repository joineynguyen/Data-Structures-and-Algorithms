/*
Joiney Nguyen

The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
*/

class Solution 
{
    public int tribonacci(int n) 
    {
       return getTri(n, 0, 1, 1);
    }
    
    private int getTri(int n, int one, int two, int three)
    {
        if(n == 0)
        {
            return 0;
        }
        
        if(n == 1 || n == 2)
        {
            return 1;
        }
        
        int sum = one + two + three;
        
        if(n == 3)
        {
            return sum;
        }
        
        return getTri(n - 1, two, three, sum);
    }
}
