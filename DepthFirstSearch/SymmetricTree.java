/*
Joiney Nguyen

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
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
    public boolean isSymmetric(TreeNode root) 
    {
        if(root == null)
        {
            return true;
        }
        
        return isSymmetricHelper (root.left, root.right);
    }
    
    boolean isSymmetricHelper(TreeNode root1, TreeNode root2)
    {
        if(root1 == null && root2 == null)
        {
            return true;
        }
        
        if(root1 == null ^ root2 == null)
        {
            return false;
        }
        
        if(root1.val != root2.val)
        {
            return false;
        }
        
        return isSymmetricHelper(root1.left, root2.right) && isSymmetricHelper(root1.right, root2.left);
    }
}
