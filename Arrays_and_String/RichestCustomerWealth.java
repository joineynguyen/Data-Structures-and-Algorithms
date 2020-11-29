/*
Joiney Nguyen

You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the ith customer has in the jth bank. Return the wealth that the richest customer has.
A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

*/

class Solution {
    public int maximumWealth(int[][] accounts) 
    {
        int maxSum = 0;
        int currentSum;
        
        for(int i = 0; i < accounts.length; i++)
        {
            currentSum = 0;
            
            for(int j = 0; j < accounts[i].length; j++)
            {
                currentSum = currentSum + accounts[i][j];
            }
            
            if(currentSum > maxSum)
            {
                maxSum = currentSum;
            }
        }
        
        return maxSum;
        
    }
}
