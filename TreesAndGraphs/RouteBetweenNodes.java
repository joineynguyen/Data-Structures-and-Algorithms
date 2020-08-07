/**
 * Joiney Nguyen
 *
 * Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 *
 * Definition for Directed graph.
 * 
 * class DirectedGraphNode 
 * {
 *     int value;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         value = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
import java.util.*;

public class Solution
{
	//returns true if start and target graph nodes are reachable in route, else false
	public boolean isReachable(ArrayList<DirectedGraphNode> graph, DirectedGraphNode start, DirectedGraphNode target)
	{
		
		if(start == target)
		{
			return true;
		}

		//queue to offer next node to be inspected of their neighbors
		LinkedList<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();

		//visisted hash set to keep record if we went through the node's neighbor
		//we do not want to encounter any loops by examinng same nodes 
		HashSet<DirectedGraphNode> visited = new HashSet<DirectedGraphNode>();

		//add start node to queue to begin algorithm of checking the nodes neighbors
		queue.offer(start);
		//mark the start node visited as we will check its neighbors
		visited.add(start);

		//while there is more unvisited nodes in queue, keep searching their neighbors
		while(!queue.isEmpty())
		{
			//dequeue from queue to current variable
			DirectedGraphNode current = queue.poll();

			//iterate through the current node's neighbors
			for(DirectedGraphNode neighbor : current.neighbors)
			{
				//if neighbor is also the target return true
				if(neighbor == target)
				{
					return true;
				}

				//if we haven't check the current node's neighbors' neighbors.. add it to queue then mark it visited
				if(!visited.contains(current))
				{
					queue.offer(current);
					visited.add(current);
				}
			}
		}

		//return false if we did not find our target node in any of the nodes starting at start node
		return false;


	}

}
