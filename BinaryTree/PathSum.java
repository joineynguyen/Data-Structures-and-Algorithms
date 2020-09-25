/*
Joiney Nguyen

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,
*/


class Solution 
{
    public boolean hasPathSum(TreeNode root, int sum) 
    {
        return getPathSum(root, sum, 0);
    }
    
    public boolean getPathSum(TreeNode root, int sum, int count)
    {
        if(root == null)
        {
            return false;
        }
        
        count = count + root.val;
        
        if(root.left == null && root.right == null)
        {
            if(count == sum)
            {
                return true;
                
            }
        }
        
        return getPathSum(root.left, sum, count) || getPathSum(root.right, sum, count);
        
    }
}
