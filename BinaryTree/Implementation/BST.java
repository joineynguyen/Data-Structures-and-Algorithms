package bst;


public class BST 
{
	class TreeNode
	{
	    int value;
	    TreeNode left, right;
	    
	    public TreeNode(int v)
	    {
	        value = v;
	        left = right = null;
	    }
	}
	
	
	TreeNode root;
    
    public BST()
    {
        root = null;
    }
    
    public void insert(int v)
    {
        root = insertRec(root, v);
    }
    
    public TreeNode insertRec(TreeNode root, int v)
    {
        if(root == null)
        {
            root = new TreeNode(v);
            return root;
        }
        
        if(v < root.value)
        {
            root.left = insertRec(root.left, v);
        }
        else if(v > root.value)
        {
            root.right = insertRec(root.right, v);
        }
        
        return root;
        
    }
    
    public void delete(int key)
    {
        root = deleteRec(root, key);
    }
    
    public TreeNode deleteRec(TreeNode root, int key)
    {
        if(root == null)
        {
            return root;
        }
        
        if(key < root.value)
        {
            root.left = deleteRec(root.left, key);
        }
        else if(key > root.value)
        {
            root.right = deleteRec(root.right, key);
        }
        else //matching values, this node needs to be deleted
        {
            if(root.left == null && root.right == null) //no children
            {
                return null;
            }
            else if(root.left != null && root.right == null)//no right child
            {
                return root.left;
            }
            else if(root.right != null && root.left == null)//no left child
            {
                return root.right;
            }
            else if(root.left != null && root.right != null)//both children
            {
                root.value = getInOrderSuccessorValue(root.right); // get in order successor value and replace it with node to be deleted
                
                root.right = deleteRec(root.right, root.value);
            }
        }
        
        return root;
    }
    
    public int getInOrderSuccessorValue(TreeNode root)
    {
    	TreeNode current = root;
    	
        while(current.left != null)
        {
            current = current.left;
        }
        
        return current.value;
    }
    
    public void inOrder(TreeNode root)
    {
        inOrderTraversal(root);
    }
    
    public void inOrderTraversal(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }
    
    public static void main(String[] args) 
    {
       BST tree = new BST();
       tree.insert(50);
       tree.insert(30);
       tree.insert(20);
       tree.insert(40);
       tree.insert(70);
       tree.insert(60);
       tree.insert(80);
       
       tree.inOrder(tree.root);
       
       System.out.println("");
       
       tree.delete(20);
       tree.inOrder(tree.root);
       
       System.out.println("");
       
       tree.delete(30);
       tree.inOrder(tree.root);
       
       System.out.println("");
       
       tree.delete(50);
       tree.inOrder(tree.root);
       
    }

}
