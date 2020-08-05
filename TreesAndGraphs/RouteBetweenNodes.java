/* Joiney Nguyen
*
* Given a directed graph, design an algorithm to find out whether there is a
* route between two nodes. */

import java.util.*; 

public class Graph
{
	//num of vertices
	public int numOfVertices;
	//create array called adj with capability in storing linked list
	public LinkedList<Integer>[] adj;


	//graph constructor with graph size/number of vertices for paramater 'v'
	Graph(int v)
	{
		numOfVertices = v;

		//instantiate adj linked list array
		adj = new LinkedList[v];
		//instantiate linked list for each array element
		for(int i = 0; i < v; i++)
		{
			adj[i] = new LinkedList<Integer>();
		}
	}

	//function to add an edge into the graph from vertex1 to vertex2
	void addEdge(int vertex1, int vertex2)
	{
		adj[vertex1].add(vertex2);
	}

	Boolean isReachable(int current, int target)
	{
	
		//boolean array to keep track of visited vertices
		boolean[] visited = new boolean[numOfVertices];

		//create queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		//mark current starting vertex as visited and enqueue it
		visited[current] = true;
		queue.add(current);

		// 'i' will be used to get all adjacent vertices of a vertex
		Iterator<Integer> adjacentVertexIterator; 

		while(queue.size() != 0)
		{
			//dequeue a vertex from queue and print it
			current = queue.poll();

			//iterator for all adjacents to current vertex
			adjacentVertexIterator = adj[current].listIterator();

			//while there is adjacent vertex to current vertex
			while(adjacentVertexIterator.hasNext())
			{
				//set current vertex's next adjacent vertex to n
				int currentAdjacentVertex = adjacentVertexIterator.next();

				//if the adjacent vertex is the end point, then return true
				//since theere is a route between starting and end vertices.
				if(currentAdjacentVertex == target)
				{
					return true;
				}

				if(!visited[currentAdjacentVertex])
				{
					visited[currentAdjacentVertex] = true;
					queue.add(currentAdjacentVertex);
				}

			}

		}

		return false;

	}

	public static void main(String[] args)
	{
		Graph g = new Graph(4);
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 

        if(g.isReachable(1,3))
        {
        	System.out.println("True");
        }
        else
        {
        	System.out.println("False");
        }
  
	}

}






