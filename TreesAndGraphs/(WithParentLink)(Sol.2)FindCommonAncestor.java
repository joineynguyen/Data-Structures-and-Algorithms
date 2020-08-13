/*	Joiney
	
	Find the common ancestor tree node between two treenodes

*/

public class Solution
{
	TreeNode getCommonAncestor(TreeNode root, TreeNode a, TreeNode b)
	{
		
		//if treenodes a or b is not under root, cannot continue algo
		if(!covers(root, a) && !covers(root, b))
		{
			return null;
		}

		if(covers(a, b))
		{
			return a;
		}

		if(covers(b, a))
		{
			return b;
		}

		//We get the sibling node of node a to search that subtree instead of the whole 
		//subtree starting form parent
		TreeNode sibling = getSibling(a);
		TreeNode parent = a.parent;

		//we traverse up search each parent's sibling subtree until we find one that covers b
		//when then return the current parent since it also covers the other subtree that was 
		//is connected to a
		while(!covers(sibling, b))
		{
			sibling = getSibling(parent);
			parent = parent.parent;
		}

		return parent;

		
	}




	//traversing down root's left and children, we see if treenode N is underneath root
	Boolean covers(TreeNode root, TreeNode n)
	{
		if(root == null)
		{
			return false;
		}

		if(root == n)
		{
			return true;
		}
	
		return covers(root.left, n) || covers(root.right, n);
	}

	//get sibling of treenode. if tree node n is left child, return right sibling. vice versa
	TreeNode getSibling(TreeNode n)
	{
		if(n == null || n.parent == null)
		{
			return null;
		}

		TreeNode parent = n.parent;

		return(parent.left == n ? parent.right : parent.left);
	}

}
