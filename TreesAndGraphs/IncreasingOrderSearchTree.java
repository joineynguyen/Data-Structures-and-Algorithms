/*
Joiney Nguyen

Given a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9  

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
    public TreeNode increasingBST(TreeNode root) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root, list);
        TreeNode newTree = new TreeNode();
        TreeNode current = newTree;
        
        for(int i : list)
        {
            current.right = new TreeNode(i);
            current = current.right;
        }
        
        return newTree.right;
    }
    
    public void inOrder(TreeNode node, ArrayList<Integer> list)
    {
        if(node == null)
        {
            return;
        }
        
        inOrder(node.left, list);
        list.add(node.val);
        inOrder(node.right, list);
    }
}
