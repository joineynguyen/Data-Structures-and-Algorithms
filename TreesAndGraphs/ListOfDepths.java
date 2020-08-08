/* Joiney Nguyen
 *
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 */


//uses BFS to return arraylist of lists for each level in the binary tree
//each list in the arraylist contains the tree nodes per level.
public ArrayList<LinkedList<TreeNode>> createLevelList(TreeNode root)
{
	//arraylist of lists for each level in binary tree
	ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
	//list to store tree nodes in the current level
	LinkedList<TreeNode> current = new LinkedList<TreeNode>();

	if(root != null)
	{
		current.add(root);
	}

	//while there are more children to organize
	while(current.size() > 0)
	{
		
		result.add(current);
		//to store current level, so 'current' can be open for next level
		LinkedList<TreeNode> parents = current;
		//create new list for next level
		current = new LinkedList<TreeNode>();

		//iterate through all of the parent level to add its children to current level
		for(TreeNode parent : parents)
		{
			if(parent.left != null)
			{
				current.add(parent.left);
			}

			if(parent.right != null)
			{
				current.add(parent.right);
			}
		}
	}

	return result;
}
