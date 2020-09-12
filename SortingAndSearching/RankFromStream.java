/*Joiney Nguyen

Imagine you are reading in a stream of integers. Periodically, you wish to be able
to look up the rank of a number x (the number of values less than or equal to x). Implement the data
structures and algorithms to support these operations. That is, implement the method track (int
x), which is called when each number is generated, and the method getRankOfNumber(int
x), which returns the number of values less than or equal to X (not including x itself).
EXAMPLE
Stream(inorderofappearance):5, 1,4,4, 5, 9, 7, 13, 3
getRankOfNumber(l) e
getRankOfNumber(3) 1
getRankOfNumber(4) 3
*/

package prac;

class Node
{
    public int num;
    public Node left, right;
    //To keep track of how many smaller valued nodes have passed them
    public int rank = 0;
    
    public Node(int num)
    {
        this.num = num;
        left = null;
        right = null;
        
    }
   
}

public class BST
{
    Node root;
    
    //Track function is identical to add functin for binary search tree with added tweaks to increase each node's rank as nodes are being passed through
    public void track(int num)
    {
        Node new_node = new Node(num);
        
        if(this.root == null)
        {
            this.root = new_node;
        }
        else
        {
            Node focusNode = this.root;
            Node parent;
        
            while(true)
            {
                parent = focusNode;
            
                if(new_node.num <= focusNode.num)
                {
                    //If the new node passes through and the current focus node we are on is larger, we increment the focus node's rank by 1
                    focusNode.rank += 1;
                    
                    focusNode = focusNode.left;
                    
                    if(focusNode == null)
                    {
                        parent.left = new_node;
                        
                        return;
                    }
                   
                }
                else if(new_node.num > focusNode.num)
                {
                    //If the new node passes through but is larger, we increment the new node's rank by 1
                    new_node.rank += 1;
                    
                    focusNode = focusNode.right;

                    if(focusNode == null)
                    {
                        parent.right = new_node;
                        return;
                    }
                    
                }

            }
        }
        
    }
    
    //Gets the node in the tree with mathing num val then return its rank number
    public int getRankOfNumber(int num)
    {
        Node focusNode = this.root;
    
        while(focusNode != null)
        {
            if(num == focusNode.num)
            {
                return focusNode.rank;
            }
            else if(num < focusNode.num)
            {
                focusNode = focusNode.left;
            } 
            else if(num > focusNode.num)
            {
                focusNode = focusNode.right;
            }
        }
        System.out.println("none found");
        return -1;
    }
    
    public void inOrderTraversal(Node focusNode)
    {
        if(focusNode == null)
        {
            return;
        }
        
        inOrderTraversal(focusNode.left);
        System.out.println(focusNode.num);
        inOrderTraversal(focusNode.right);
    }
    
    public static void main(String[] args)
    {
        BST myBST = new BST();
        
        myBST.track(5);
        myBST.track(1);
        myBST.track(4);
        myBST.track(4);
        myBST.track(5);
        myBST.track(9);
        myBST.track(7);
        myBST.track(13);
        myBST.track(3);
          
        myBST.inOrderTraversal(myBST.root);
        
        System.out.println("--------------------");
        
        System.out.println(myBST.getRankOfNumber(4));
    }
}
