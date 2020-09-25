/*
Joiney Nguyen

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
    int sum = 0;
    int max = Integer.MIN_VALUE;
    
    public int deepestLeavesSum(TreeNode root) 
    {
        getMaxDepth(root, 0);
        getDeepestLeavesSum(root, 0);
        return sum;
    }
    
    public void getDeepestLeavesSum(TreeNode root, int depth)
    {
        if(root == null)
        {
            return;
        }
        
        depth += 1;
        
        if(root.left == null && root.right == null && depth == max)
        {
            sum += root.val;
        }
        
        getDeepestLeavesSum(root.left, depth + 1);
        getDeepestLeavesSum(root.right, depth + 1);
    }
    
    public void getMaxDepth(TreeNode root, int depth)
    {
        if(root == null)
        {
            return;
        }
        
        depth += 1;
        
        if(root.left == null && root.right == null)
        {
            if(depth > max)
            {
                max = depth;
            }
            
        }
        
        getMaxDepth(root.left, depth + 1);
        getMaxDepth(root.right, depth + 1);
        
    }
}
