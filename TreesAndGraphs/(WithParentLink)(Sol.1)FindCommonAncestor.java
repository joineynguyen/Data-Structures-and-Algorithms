/* 	Joiney
	
	We are trying to find an common parent between two nodes that are built with a parent link.
*/

public class Solution
{
	TreeNode findAncestor(TreeNode a, TreeNode b)
	{
		int difference = getDepth(a) - getDepth(b);

		TreeNode shallowerTreeNode = difference > 0 ? bDepth : aDepth;
		TreeNode deeperTreeNode = difference > 0 ? aDepth : bDepth;

		deeperTreeNode = goUp(deeperTreeNode, Math.abs(difference));

		//now that both treenodes are met at same level, we traverse upwards until either one is null or they both match
		while(shallowerTreeNode != deeperTreeNode && shallowerTreeNode != null && deeperTreeNode != null)
		{
			shallowerTreeNode = shallowerTreeNode.parent;
			deeperTreeNode = deeperTreeNode.parent;
		}

		//any node reaches null, we did not find our ancestor. if either not null, we found our culprit
		return (shallowerTreeNode == null || deeperTreeNode == null ? null : shallowerTreeNode);

	}

	//to go up from deeperTreeNode to match depth of shallowerTreeNode
	TreeNode goUp(TreeNode deeperTreeNode, int difference)
	{
		while(difference > 0 && deeperTreeNode != null)
		{
			deeperTreeNode = deeperTreeNode.parent;
			difference -= 1;
		}

		return deeperTreeNode;
	}

	int getDepth(TreeNode n)
	{
		TreeNode current = n;
		int depth = 0;

		while(n != null)
		{
			n = n.parent;
			depth ++;
		}

		return depth;
	}
}
