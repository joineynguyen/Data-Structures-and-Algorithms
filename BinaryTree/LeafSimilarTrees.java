/*
Joiney Nguyen

Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence. For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).

Two binary trees are considered leaf-similar if their leaf value sequence is the same.

Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.

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
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) 
    {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        getLeafSequence(list1, root1);
        getLeafSequence(list2, root2);
        
        if(list1.equals(list2))
        {
            return true;
        }
        
        return false;
    }
    
    public void getLeafSequence(List<Integer> result, TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        if(root.left == null && root.right == null)
        {
            result.add(root.val);
            return;
        }
        
        if(root.left != null)
        {
            getLeafSequence(result, root.left);
        }
        
        if(root.right != null)
        {
            getLeafSequence(result, root.right);
        }
    
    }
    
    
    
    
    
    
}
