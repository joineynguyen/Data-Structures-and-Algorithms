/*
Joiney Nguyen

In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

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
    public boolean isCousins(TreeNode root, int x, int y) 
    {
        boolean xExists = false;
        boolean yExists = false;
        
        if(root == null)
        {
            return false;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
           
            for(int i = 0; i < size; i++)
            {
                
                TreeNode current = q.poll();
                
                if(current.left != null && current.right != null)
                {
                    if(current.left.val == x && current.right.val == y)
                    {
                        return false;
                    }
                    else if(current.left.val == y && current.right.val == x)
                    {
                        return false;
                    }
                }
                
                if(current.val == x)
                {
                    xExists = true;
                }
                
                if(current.val == y)
                {
                    yExists = true;
                }
                                  
                if(current.left != null)
                {
                    q.offer(current.left);
                }
                
                if(current.right != null)
                {
                    q.offer(current.right);
                }
                
            }
            
            if(xExists == true && yExists == true)
            {
                return true;
            }
            else
            {
                xExists = false;
                yExists = false;
            }
            
        }
        
        return false;
           
    }
}
