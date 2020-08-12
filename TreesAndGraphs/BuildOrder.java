/* 
Joiney Nguyen

You are given a list of projects and a list of dependencies (which is a list of pairs of
projects, where the second project is dependent on the first project). All of a project's dependencies
must be built before the project is. Find a build order that will allow the projects to be built. If there
is no valid build order, return an error.
*/

ArrayList<Project> getOrder(String[] projects, String[][] dependencies)
{

	Graph graph = buildGraph(projects, dependencies);

	return buildOrder(graph.getProjects());
}

//function to build the graph by inserting projects and their neighbors
Graph buildGraph(String[] projects, String[][] dependencies)
{
	Graph graph = new Graph();

	//to add all projects from projects array into graph
	for(String project : projects)
	{
		graph.createOrGetProject(project);
	}

	//to add all of project's neighbors from a to b, where a must be built before b
	for(String[] dependency : dependencies)
	{
		String projectName1 = dependency[0];
		String projectName2 = dependency[1];

		graph.createEdge(projectName1, projectName2);
	}

	return graph;
}

 Project[] buildOrder(ArrayList<Project> projects)
 {
 	Project[] order = new Project[projects.size()];

 	//we begin by adding projects with initial non depended projects 
 	int orderTailIndex = addNonDependentProjects(order, projects, 0);

 	//to iterate through order list with non depended projects
 	int toBeProcessed = 0;

 	//go through each project in order list , subbtract 1 number of dependency from each of their children
 	//and then see if any of their children results to being non dependent project,
 	//if they are, then add to order list and continue processing the rest of the order list
 	while(toBeProcessed < order.length)
 	{
 		Project currentProject = order[toBeProcessed];

 		//there are no more reamining projects that are non-depending
 		if(currentProject == null)
 		{
 			return null;
 		}

 		ArrayList<Project> currentChildren = currentProject.getChildren();

 		for(Project child : currentChildren)
 		{
 			//when their number of dependency reaches 0, that project is then non-dependent 
 			child.subtractDependency();
 		}

 		//add any non dependent projcts from current project's children and return the tail index of order
 		orderTailIndex = addNonDependentProjects(order, currentChildren, orderTailIndex);

 		toBeProcessed += 1;

 	}


 	return order;
 
 }

/* function takes in order array to add on next project, 
   projects arraylist to find next project with 0 dependencies,
   continueIndex to place next project at that index of order list*/
int addNonDependentProjects(Project[] order, ArrayList<Project> projects, int startIndex)
{
	for(Project project : projects)
	{
		if(project.getNumOfDependencies() == 0)
		{
			order[startIndex] = project;
			startIndex ++;
		}
	}

	return startIndex;
}





public class Graph
{
	//have a list of projects to explore their dependencies
	private ArrayList<Project> projects = new ArrayList<Project>();
	//to handle duplicates of projects
	private HashMap<String, Project> map = new HashMap<String, Project>();


	public Project createOrGetProject(String projectName)
	{
		
		if(!map.containsKey(projectName))
		{
			Project newProject = new Project(projectName);

			projects.add(newProject);
		
			map.put(projectName, newProject);
		}
	
		return map.get(projectName);
	}

	
	public void createEdge(String projectName1, String projectName2)
	{
		Project a = createOrGetProject(projectName1);
		Project b = createOrGetProject(projectName2);

		a.addNeighbor(b);
	}

	public ArrayList<Project> getProjects()
	{
		return projects;
	}


}

public class Project 
{
	//this project's children will depend on them being built first in order to be built
	private ArrayList<Project> children = new ArrayList<Project>();
	//to handle duplicate children
	private HashMap<String, Project> map = new HashMap<String, Project>();
	private String name;
	//how many projects they depend on being built first
	private int dependencies = 0;

	public Project(String name)
	{
		this.name = name;
	}

	public void addNeightbor(Project project)
	{
		if(!map.containsKey(project.name))
		{
			children.add(project);
			map.put(project.name, project);
			project.addDependency();
		}
	}

	//add a number of projects they depend on being built first
	public void addDependency()
	{
		dependencies += 1;
	}
	//subtract a number of projects they depend on being built first
	public void subtractDependency()
	{
		dependencies -= 1;
	}

	public ArrayList<Project> getChildren()
	{
		return children;
	}

	public int getNumOfDependencies()
	{
		return dependencies;
	}
}
