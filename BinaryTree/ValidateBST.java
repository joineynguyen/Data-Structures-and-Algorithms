/* Joiney Nguyenm
 * 
 * Implement a function to check if a binary tree is a binary search tree.
 */

class Solution
{
   public boolean isValidBST(TreeNode root)
   {
      return validate (root, null, null);
   }

   public boolean validate(TreeNode root, Integer min, Integer max)
   {
      //base case for leaf nodes
      if(root == null)
      {
         return true;
      }
      
      //if there is a min value, we check if the current tree node's right child value breaks the BST property by being smaller or equal to min
      
      //if there is a max value, we check if the current tree node's left child value breaks the BST property by being bigger or equal to max

      //if the current tree node value breaks the BST property, we return false
      else if((max != null && root.val >= max) ||  (min != null && root.val <= min))
      {
         return false;
      }
   
      //if no BST property is broken, we continue iterating through the rest of the tree and validating the left and right children of subtrees.
      
      //both left and right children must return true in order to return method true, making the sub tree a true BST
      else
      {
         return validate(root.left, min, root.val) && validate(root.right, root.val, max);
      }
   }
}
