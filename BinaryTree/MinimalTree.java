/*
 * Joiney Nguyen
 *
 * Given a sorted (increasing order) array with unique integer elements, write an algorithm
 * to create a binary search tree with minimal height.
 */


import java.util.*;

class Node
{
	int value;
	//binary trees have up to 2 chidren, left and right node children
	Node left, right;

	Node(int val)
	{
		value = val;
		left = right = null;
	}
}


public class BinaryTree
{
	static Node root;


	public Node sortedArrayToBST(int[] arr, int startIndex, int endIndex)
	{
		if(startIndex > endIndex)
		{
			return null;
		}

		//get middle index to make root
		int mid = (startIndex + endIndex) / 2;

		Node node = new Node(arr[mid]);

		node.left = sortedArrayToBST(arr, startIndex, mid - 1);
		node.right = sortedArrayToBST(arr, mid + 1, endIndex);

		return node;

	}

	//function makes parameter simple by only taking array
	//then getting the array's start and end index to put in the algorithm
	public Node sortedArrayToBST(int[] arr)
	{
		return sortedArrayToBST(arr, 0, arr.length - 1);
	}




	//prints tree in pre order traversal (node, left node, then right node)
	public void preOrder(Node node)
	{
		if(node == null)
		{
			return;
		}

		System.out.print(node.value + " ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void main(String[] args)
	{
		BinaryTree myTree = new BinaryTree();
		int arr[] = new int[] {1, 2, 3, 4, 5, 6, 7};
		root = myTree.sortedArrayToBST(arr);
		System.out.println("Preorder traversal of constructed BST");
		myTree.preOrder(root);
	}
}





