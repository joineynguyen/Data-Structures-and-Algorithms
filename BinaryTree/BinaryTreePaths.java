/*
Joiney Nguyen

Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

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
    public List<String> binaryTreePaths(TreeNode root) 
    {
        List<String> pathList = new ArrayList<>();
        getPath(root, "", pathList);
        
        return pathList;
    }
    
    public void getPath(TreeNode root, String path, List<String> list)
    {
      
        if(root == null)
        {
            return;
        }
        
        path = path + root.val;
        
        if(root.left == null && root.right == null)
        {
            list.add(path);
            return;
        }
        
        path = path + "->";
        
        getPath(root.left, path, list);
        getPath(root.right, path, list);
        
    }
}
