/*
Joiney Nguyen

Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
*/

class Solution 
{
    public boolean isSameTree(TreeNode p, TreeNode q) 
    {
        //If both nodes are null. also base case for reaching end of tree
        if(p == null && q == null)
        {
            return true;
        }
        
        //If one of two nodes are null
        if(p == null && q != null || p != null && q == null)
        {
            return false;
        }
        
        //If one node is larger than other
        if(p.val > q.val || p.val < q.val)
        {
            return false;
        }
        
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
