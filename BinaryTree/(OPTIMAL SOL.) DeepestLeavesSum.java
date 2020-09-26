/* Joiney Nguyen

Given a binary tree, return the sum of values of its deepest leaves.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    int maxDepth = Integer.MIN_VALUE;
    int sum = 0;
    
    public int deepestLeavesSum(TreeNode root) 
    {
        dfs(root, 1);
        
        return sum;
    }
    
    public void dfs(TreeNode root, int depth)
    {
        if(root == null)
        {
            return;
        }
        
        if(depth > maxDepth)
        {
            sum = 0;
            maxDepth = depth;
        }
        
        if(depth == maxDepth)
        {
            sum += root.val;
        }
        
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
