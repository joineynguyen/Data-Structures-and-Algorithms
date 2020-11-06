/*
Joiney Nguyen

On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
*/

class Solution 
{
    public int minCostClimbingStairs(int[] cost) 
    {
        int first = cost[0];
        int second = cost[1];
        
        if(cost.length <= 2)
        {
            return Math.min(first,second);
        }

        for(int i = 2; i < cost.length; i++)
        {
            int currentCost = cost[i] + Math.min(first, second);
            first = second;
            second = currentCost;
        }
        
        return Math.min(first, second);
    }
}
