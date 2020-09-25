/* Joiney Nguyen
 *
 * Write an algorithm to find the "next" node (i .e., in-order successor) of a given  
 * node in a binary search tree. You may assume that each node has a link to its parent.
 */

class Solution
{

   public class TreeNode
   {
      int value;
      TreeNode left, right, parent;

      TreeNode(int val)
      {
         value = val;
      }
   }

   //returns tree node that comes after the target tree node in in-order traversal
   public TreeNode inOrderSuccessor(TreeNode target)
   {
      //since we our goal is the sucessor, the first thing we do is look at the target's right child
      if(target.right != null)
      {
         //if the target's right child has no children, we return the target's right child. Because if the target's right child do have children, we would have to get its left most child. The left most child would be the node right after the target node in value.
         return getMostLeftChild(target.right);
      }
      //if the target's right child is null, we traverse up of the target
      else
      {
         TreeNode current = target;
         TreeNode parent = current.parent;

         //if we traverse up from the target node and its the parent's right child, the target node is in the parent's right subtree. And while the target has no right child, this means we are in a deadend subtree and need to keep traversing upwards until we find the parent that is eventually going to be on the right that has the current node (used to traverse) as its left child node. This means the parent is out of that dead end sub tree and will have a value bigger than the target node's value, making the parent the successor.

         //if we traverse up and the parent's left child is the target node, then we know that the parent is the successor.

         //both of the comments above are logical due to the nature of in order traversal.
         while(parent != null && parent.left != current)
         {
            current = parent;
            parent = parent.parent;
         }

         return parent;
      }
   }

   public TreeNode getMostLeftChild(TreeNode node)
   {
      if(node == null)
      {
         return null;
      }
     
      TreeNode current = node;

      while(current.left != null)
      {
         current = current.left;
      }

      return current;
   }
}
