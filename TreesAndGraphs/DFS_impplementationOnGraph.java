/*
Joiney Nguyen

DFS search on graph implementation

*/


package prac;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph
{
    int numOfVertices;
    LinkedList<Integer>[] adj;
    
    public Graph(int verts)
    {
        numOfVertices = verts;
        adj = new LinkedList[numOfVertices];
        
        for(int i = 0; i < numOfVertices; i++)
        {
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdge(int fromVertice, int toVertice)
    {
        adj[fromVertice].add(toVertice);
    }
    
    public void dfsUntil(int vertice, boolean[] visited)
    {
        visited[vertice] = true;
        
        Iterator<Integer> i = adj[vertice].listIterator();
        
        while(i.hasNext())
        {
            int current = i.next();
            if(!visited[current])
            {
                dfsUntil(current, visited);
            }
        }
    }
    
    public void dfs(int vertice)
    {
        boolean[] visited = new boolean[numOfVertices];
        
        dfsUntil(vertice, visited);
        
        
    }
    
    public static void main(String[] args)
    {
        
    }
    
    
}
