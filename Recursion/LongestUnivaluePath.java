/* Joiney Nguyen
Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.
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
    int max;
    
    public int longestUnivaluePath(TreeNode root) 
    {
        if(root == null)
        {
            return 0;
        }
        
        max = Integer.MIN_VALUE;
        arrowLength(root);
        return max;
    }
    
    public int arrowLength(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }
        
        int left = arrowLength(root.left);
        int right = arrowLength(root.right);
        
        int arrowLeft = 0, arrowRight = 0;
        
        if(root.left != null && root.left.val == root.val)
        {
            arrowLeft = left + 1;
        }
        
        if(root.right != null && root.right.val == root.val)
        {a
            arrowRight = right + 1;
        }
        
        max = Math.max(max, arrowRight + arrowLeft);
        
        return Math.max(arrowLeft, arrowRight);
    }
}
