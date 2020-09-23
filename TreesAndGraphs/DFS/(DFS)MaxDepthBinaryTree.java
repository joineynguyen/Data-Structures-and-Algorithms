/*
Joiney Nguyen

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
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
    int maxDepth;
    
    public int maxDepth(TreeNode root) 
    {
        if(root == null)
        {
            return 0;
        }
        
        getMaxDepth(root, 1);
        
        return maxDepth;
    }
    
    public void getMaxDepth(TreeNode node, int currentDepth)
    {
        if(node == null)
        {
            return;
        }
        
        maxDepth = Math.max(maxDepth, currentDepth);
        
        getMaxDepth(node.left, currentDepth + 1);
        getMaxDepth(node.right, currentDepth + 1);
    }
}
