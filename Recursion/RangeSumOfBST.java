/*
Joiney Nguyen

Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32

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
    
    public int rangeSumBST(TreeNode root, int L, int R) 
    {
        
        dfs(root, L, R);
        return sum;
    }
    
    public void dfs(TreeNode root, int L, int R)
    {
        if(root == null)
        {
            return;
        }
        
        if(root.val >= L && root.val <= R)
        {
            sum = sum + root.val;
        }
        
        dfs(root.left, L, R);
        dfs(root.right, L, R);
    }
}
