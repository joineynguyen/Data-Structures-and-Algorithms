package myPackage;

import java.util.ArrayList;
import java.util.HashMap;

//simpleton class that will handle all classes in Main
public class CallManager
{
	/*employeeLevels.get(0) = respondents, employeesLevels.get(1) = managers, employeesLevels.get(2) = directors
  Store employees
  Levels: respondents = 0, managers = 1, directors = 2
  */
  final int employeeMaxLevel = 2;
  private ArrayList<ArrayList<Employee>> employeeLevels = new ArrayList<ArrayList<Employee>>(employeeMaxLevel +1 );
  private ArrayList<Employee> respondents = new ArrayList<Employee>();
  private ArrayList<Employee> managers = new ArrayList<Employee>();
  private ArrayList<Employee> directors = new ArrayList<Employee>();
  
  //places calls in here if there are no available employees that can handle the call
  private ArrayList<ArrayList<Call>> callQueue = new ArrayList<ArrayList<Call>>(employeeMaxLevel + 1);
  
  /*Helps prevent creating employees with same employee ids
    Also helps with searching for employees (future proofing)
  */
  private HashMap<Integer, Employee> map = new HashMap<Integer, Employee>();
  
  //we set the call manager to initially have 4 respondents, 2 managers, and 1 director
  public CallManager()
  {
      employeeLevels.add(respondents);
      employeeLevels.add(managers);
      employeeLevels.add(directors);
      
      callQueue.add(new ArrayList<Call>());
      callQueue.add(new ArrayList<Call>());
      callQueue.add(new ArrayList<Call>());
      
      createRespondent(1, "Mike Phillips");
      createRespondent(2, "Joe Biden");
      createRespondent(3, "Sarah Marshall");
      createRespondent(4, "George Mickens");
      
      createManager(5, "Bob Styles");
      createManager(6, "Jenny Polk");
      
      createDirector(7, "Donald Trump");  
  }
    
  //the 3 create functions below help create the initial employees. we can imagine these are the employees clocked in for the day
  public void createRespondent(int employeeID, String fullName)
  {
      if(!map.containsKey(employeeID))
      {
          Respondent newRespondent = new Respondent(employeeID, fullName, this);
          respondents.add(newRespondent);
          map.put(employeeID, newRespondent);
      }
      else
      {
          System.out.println("The employee ID is currently being used.");
      }
  }
  
  public void createManager(int employeeID, String fullName)
  {
      if(!map.containsKey(employeeID))
      {
          Manager newManager = new Manager(employeeID, fullName, this);
          managers.add(newManager);
          map.put(employeeID, newManager);
      }
      else
      {
          System.out.println("The employee ID is currently being used.");
      }
  }
  
  public void createDirector(int employeeID, String fullName)
  {
      if(!map.containsKey(employeeID))
      {
          Director newDirector = new Director(employeeID, fullName, this);
          directors.add(newDirector);
          map.put(employeeID, newDirector);
      }
      else
      {
          System.out.println("The employee ID is currently being used.");
      }
  }

  //Makes new call and assigns caller to it. Then find next available employee.
  public void dispatchCall(Caller caller)
  {
	  Call call = new Call(caller);
	  dispatchCall(call);
  }
  
  //Find next capable available employee for this new call that has never been in the call queue, thus having initial level 0. 
  public void dispatchCall(Call call)
  {
  	/*level 0 respondent, 1 manager, 2 director
  	Will start every call with level 0, until the call handlers increases them since they cannot handle the call
  	For flexibility, we will still get the call's level and search respected employee arraylist
  	*/
  	Employee availableEmployee = getNextAvailableEmployee(call.getCallLevel());
  	
  	if(availableEmployee != null)
  	{
  		//to change employee's available boolean status
  		availableEmployee.handleCall(call);
  		//to record who is handling the call for future references
  		call.setCallHandler(availableEmployee);
  	}
  	//If we can't find any available employees, then we place the call in callQueue for other employees to accept when they can
  	else if(availableEmployee == null)
  	{
  		System.out.println("Sorry, all representatives are currently busy. Please hold while we find the next available representative.");
  		//places call into a specific queue depending on the call's level (call level 0 will be put in arraylist(0) of callQueue arraylist
  		callQueue.get(call.getCallLevel()).add(call);
  	}
  	
  }
  
  //Helper function for dispatchCall. Searches through correct arraylist of employees looking for available employee. 
  public Employee getNextAvailableEmployee(int callLevel)
  {
	  for(int i = callLevel; i < employeeMaxLevel; i++)
	  {
		  for(Employee currentEmployee : employeeLevels.get(i))
		  	{
		  		//if current employee available
		  		if(currentEmployee.getAvailability())
		  		{
		  			return currentEmployee;
		  		}
		  	}
	  }
	  return null;
  }
  
  //assigns calls from queue for employee. We assign the highest level call the current employee can handle as priority, because we don't want directors to handle respondent level calls as priority
  public void dispatchCallFromQueue()
  {
	  for(int i = 0; i < employeeMaxLevel; i ++)
	  {
		  //get next call in queue
		  Call pendingCall = callQueue.get(i).get(0);
		  callQueue.get(i).remove(0);
		  
		  //get next available employee capable of handling the call
		  Employee availableEmployee = getNextAvailableEmployee(pendingCall.getCallLevel());
			  
		  	if(availableEmployee != null)
		  	{
		  		//to change employee's available boolean status
		  		availableEmployee.handleCall(pendingCall);
		  		//to record who is handling the call for future references
		  		pendingCall.setCallHandler(availableEmployee);
		  	}
		  	//If we can't find any available employees, then we place the call in the end of callQueue so that by the time we reach to the end of the queue, employee should free up
		  	else if(availableEmployee == null)
		  	{
		  		System.out.println("Sorry, all representatives are currently busy. Please hold while we find the next available representative.");
		  		//places call into a specific queue depending on the call's level (call level 0 will be put in arraylist(0) of callQueue arraylist
		  		callQueue.get(pendingCall.getCallLevel()).add(pendingCall);
		  	}
		  
	  }
  }
  
  //add call to correct queue list is lists of queues called 'callQueue'
  public void addToCallQueue(Call call)
  {
	  this.callQueue.get(call.getCallLevel()).add(call);
  }
  
  //Assign call to employee based on their level. This function searches from their level in decreasing order, so they can take calls more suited for them
  public void assignCallToEmployee(Employee currentEmployee)
  {
	  int currentEmployeeLevel = currentEmployee.getEmployeeLevel();
	  for(int i = currentEmployeeLevel; i >= 0; i--)
	  {
		  if(callQueue.get(i).size() > 0)
		  {
			  currentEmployee.handleCall(callQueue.get(currentEmployeeLevel).get(0));
			  callQueue.get(currentEmployeeLevel).remove(0);
			  System.out.println("Found call for " + currentEmployee.getEmployeeName());
			  return;
		  }
	  }
	  System.out.println("No calls found for " + currentEmployee.getEmployeeName());
  }
}

