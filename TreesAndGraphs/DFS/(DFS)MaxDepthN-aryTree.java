/*
Joiney Nguyen
*/

class Solution 
{
    int maxDepth;
    
    public int maxDepth(Node root) 
    {
        if(root == null)
        {
            return 0;
        }
        getMaxDepth(root, 1);
        return maxDepth;
    }
    
    public void getMaxDepth(Node node, int currentDepth)
    {
        if(node == null)
        {
            return;
        }
        maxDepth = Math.max(maxDepth, currentDepth);
        
        for(Node child : node.children)
        {
            getMaxDepth(child, currentDepth + 1);
        }
    }
}
