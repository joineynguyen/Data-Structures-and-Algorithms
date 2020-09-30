/*
Joiney Nguyen

Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
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
 
    public int minDiffInBST(TreeNode root) 
    {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return getMinDiff(list);
    }
    
    public void inOrder(TreeNode root, List<Integer> list)
    {
        if(root == null)
        {
            return;
        }
        
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }
    
    public int getMinDiff(List<Integer> list)
    {
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < list.size() - 1; i++)
        {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }
}
