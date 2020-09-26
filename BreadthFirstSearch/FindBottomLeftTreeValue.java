/*
Joiney Nguyen

Given a binary tree, find the leftmost value in the last row of the tree.
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
    
    
    public int findBottomLeftValue(TreeNode root) 
    {
        int leftNum = 0;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i = 0; i < size; i ++)
            {
                TreeNode current = q.poll();
                
                if(i == 0)
                {
                    leftNum = current.val;
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
            
        }
        return leftNum;
    }
}
