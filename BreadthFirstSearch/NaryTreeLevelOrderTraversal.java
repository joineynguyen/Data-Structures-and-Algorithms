/*
Joiney Nguyen

Given an n-ary tree, return the level order traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).


*/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution 
{
    public List<List<Integer>> levelOrder(Node root) 
    {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null)
        {
            return wrapList;
        }
       
        Queue<Node> q = new LinkedList<Node>();
        
        q.offer(root);
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            wrapList.add(new LinkedList<Integer>());
  
            for(int j = 0; j < size; j++)
            {
                Node current = q.poll();
                
                wrapList.get(wrapList.size() - 1).add(current.val);
                
                for(int i = 0; i < current.children.size(); i++)
                {
                    Node child = current.children.get(i);
                    
                    q.offer(child);

                }
            }
            
        }
        return wrapList;
        
    }
}
