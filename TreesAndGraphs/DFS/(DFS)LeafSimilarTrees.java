/*
Joiney Nguyen

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.



For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

 

Example 1:


Input: root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
Output: true
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
    
    
    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        dfs(root1, sb1);
        dfs(root2, sb2);
        
        return sb1.toString().equals(sb2.toString());
        
    }
    
    public void dfs(TreeNode node, StringBuilder sb)
    {
        
        if(node == null)
        {
            return;
        }
        
        if(node.left == null && node.right == null)
        {
            sb.append(node.val + " ");
            
            
        }
        
        dfs(node.left, sb);
        dfs(node.right, sb);
        
    }
}
