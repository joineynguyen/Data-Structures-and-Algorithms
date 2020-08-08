/* Joiney Nguyen
 *
 * Given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
 */


//uses DFS to return arraylist of lists for each depth in the binary tree
//each list in the arraylist contains the tree nodes of the depth they're in.
public void createDepthList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int depth)
{
	if(root == null)
	{
		return;
	}

	LinkedList<TreeNode> list = null;

	//if current depth of tree is equal to lists size then we need to add another list to lists for the next depth
	if(lists.size() == depth)
	{
		list = new LinkedList<TreeNode>();
		lists.add(list);
	}
	//if we have already this depth's list, then get it to add more tree nodes in this depth
	else
	{
		list = lists.get(depth);
	}

	list.add(root);

	//repeat function for the depth long search in left then right tree nodes of current tree node
	createDepthList(root.left, lists, depth + 1);
	createDepthList(root.right, lists, depth + 1);


}

public ArrayList<LinkedList<TreeNode>> createDepthList(TreeNode root)
{
	ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();

	createDepthList(root, lists, 0);

	return lists;
}
