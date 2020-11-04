/*
Joiney Nguyen

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
*/

class Solution 
{
    
    
    public int minCostClimbingStairs(int[] cost)
    {
        int n = cost.length;
        int[] dp = new int[n];
        return Math.min(getMinCost(cost, n-1, dp), getMinCost(cost, n-2, dp));
    }
    
    public int getMinCost(int[] cost, int n, int[] dp)
    {
        if(n < 0)
        {
            return 0;
        }
        
        if(dp[n] != 0)
        {
            return dp[n];
        }
        
        if(n == 1 || n == 0)
        {
            return cost[n];
        }
    
        dp[n] = cost[n] + Math.min(getMinCost(cost, n-1, dp), getMinCost(cost, n-2, dp));
        
        return dp[n];
    }
}
    
