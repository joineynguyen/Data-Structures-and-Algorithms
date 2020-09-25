/*	Joiney Nguyen
	
	You are given a list of projects and a list of dependencies (which is a list of pairs of
	projects, where the second project is dependent on the first project). All of a project's dependencies
	must be built before the project is. Find a build order that will allow the projects to be built. If there
	is no valid build order, return an error.

	(DFS)	
*/

Stack getOrder(String[] projects, String[][] dependencies)
{
	Graph graph = buildGraph(projects, dependencies);
	return buildOrder(graph);

}


Stack<Project> buildOrder(Graph graph)
{
	ArrayList<Project> projects = graph.getProjects();
	Stack<Project> stack = new Stack<Project>();

	for(Project project : projects)
	{
		if(project.getState() == Project.State.BLANK)
		{
			if(!doneDFS(project, stack))
			{
				return null;
			}
		}
	}

	return stack;
}

/*to perform DFS on project node and add the reverse order 
(starting at the end of completed path) to stack */
Boolean doneDFS(Project project Stack stack)
{
	/*if run into any node ONGOING then there is a loop we don't want.
	  Once we pass the node and set it ONGOING, we want it to reach the end of the path and mark 
	  every project node COMPLETED once we reach the end of the path from the starting project node*/
	if(project.getState() == Project.State.ONGOING)
	{
		return false;
	}

	/* If the current project node is blank, it means we haven't check its children which we need to do */
	if(project.getState() == Project.State.BLANK)
	{
		/* set it ONGOING cause we are checking its children */
		project.setState(Project.State.ONGOING);

		ArrayList<Project> children = project.getChildren();

		
		for(Project child : children)
		{
			//recursive function to keep checking each childrens' children until the very end of path
			if(!doneDFS(child))
			{
				return false;
			}
		}

		//once we reach the end of the path, we start going backwards in the recursive function
		// and adding each node into stack
		stack.push(project);
		project.setState(Project.State.COMPLETE);
	}

	//if the node's state is complete then we automatically return true so we can get out of the recursion if we are in one.
	//if we are not in a recursion, then we exit out of this function because since the project node is complete, all of its childnre
	//is added to the stack and marked completed
	return true;
}

//to create projects and link them with projects and dependencies lists
Graph buildGraph(String[] projects, String[][] dependencies)
{
	Graph graph = new Graph();

	for(String project : projects)
	{
		graph.getOrCreateProject(project);
	}

	for(String[] dependency : dependencies)
	{
		Project project1 = dependency[0];
		Project project2 = dependency[1];

		project1.addNeighbor(project2);
	}

	return graph;
}

public class Graph
{
	private ArrayList<Project> projects = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();

	public Project getOrCreateProject(Project name)
	{
		if(!map.containsKey(name))
		{	
			Project newProject = new Project(name);
			map.put(name, newProject);
			projects.add(newProject);
		}

		return map.get(name);
	}

	public void createEdge(Project name1, Project name2)
	{
		Project project1 = getOrCreateProject(name1);
		Project project2 = getOrCreateProject(name2);

		project1.addNeighbor(project2);
	}

	public ArrayList<Project> getProjects()
	{
		return projects;
	}

}

public class Project
{
	private ArrayList<Project> children = new ArrayList<Project>();
	private HashMap<String, Project> map = new HashMap<String, Project>();
	public enum State { BLANK, ONGOING, COMPLETE};
	private Static state = Static.BLANK;

	private String name;

	public void setState(State st)
	{
		state = st;
	}

	public State getState()
	{
		return state;
	}

	public ArrayList<Project> getChildren()
	{
		return children;
	}

	public Project(String name)
	{
		this.name = name;
	}

	public void addNeighbor(Project project)
	{
		if(!map.containsKey(project.name))
		{
			map.put(project.name, project);
			children.add(project);
		}
	}
}












