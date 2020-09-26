/* Joiney Nguyen

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
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
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) 
    {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        bfs(root, wrapList, 1);
        
        return wrapList;
        
        
    }
    
    public void bfs(TreeNode root, List<List<Integer>> wrapList, int depth)
    {
        if(root == null)
        {
            return;
        }
       
        
        if(depth > wrapList.size())
        {
            wrapList.add(0, new LinkedList<Integer>());
        }
        
        wrapList.get(wrapList.size() - depth).add(root.val);
        
        bfs(root.left, wrapList, depth + 1);
        bfs(root.right, wrapList, depth + 1);
        
        
    }
}
