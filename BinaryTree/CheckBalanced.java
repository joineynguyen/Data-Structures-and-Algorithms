/* Joiney Nguyen
 *
 * Implement a function to check if a binary tree is balanced. For the purposes of
 * this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any
 * node never differ by more than one.
 */

public boolean isBalanced(TreeNode root)
{
	if(root == null)
	{
		return true;
	}

	return height(root) != -1;
}

public int height(TreeNode node)
{

	//base case
	if(node == null)
	{
		return 0;
	}

	
	int leftHeight = height(node.left);

	//if any tree node under this tree node is unbalanced it will return -1 until traversed back to root to signal unbalanced tree
	if(leftHeight == -1)
	{
		return -1;
	}

	int rightHeight = height(node.right);

	//if any tree node under this tree node is unbalanced it will return -1 until traversed back to root to signal unbalanced tree
	if(rightHeight == -1)
	{
		return -1;
	}

	//if the tree node's children's height difference if more than 1, they have height of -1 to signal that they are unbalanced
	if( (Math.abs(leftHeight - rightHeight)) > 1)
	{
		return -1;
	}

	//tree nodes will be added will have their height of their largest child's height + 1
	return Math.max(leftHeight, rightHeight) + 1;
}


