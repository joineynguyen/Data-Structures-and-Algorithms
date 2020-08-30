package myPackage;

import java.util.ArrayList;

//factory class to create employees for different positions
abstract class Employee
{
  //full name and id number will help store the employees in a hashmap more effectively (more distinction in key values)
  protected int employeeID;
  protected String fullName;
  //position string to know who has skills to take on which calls
  protected String position;
  protected int level;
  //boolean function to help CallManager class to keep track who is currently handling a call
  protected boolean isAvailable = true;
  //stores the current call they are handling
  protected Call currentCall = null;
  protected CallManager callManager;
  protected ArrayList<Call> callRecords = new ArrayList<Call>();
  
  Employee(int employeeID, String fullName, CallManager callManager)
  {
      this.employeeID = employeeID;
      this.fullName = fullName;
      this.callManager = callManager; //this is used to connect with the main simpleton class CallManager that will connect all employees to the same arraylists of other employees 
  }
  
  //When employee handles/accepts call their availability status changes to busy and their current call variable is that call
  void handleCall(Call call)
  {
  	 if(this.isAvailable == true && currentCall == null)
      {
  		 this.isAvailable = false;
  		 this.currentCall = call;
         System.out.println(position + " " + fullName + " is now handling the call.");
      } 
  }
  //When employees completes a call, their availability status changes to free and their current call variable is free'd up/changed to null
  public void completeCall(Call call)
  {
	  if(currentCall != null)
	  {
		 this.currentCall = null;
		 this.isAvailable = true;
		 System.out.println(position + " " + fullName + " has completed the call with " + call.getCallerName());
	  }
  }
  
  //When the employees are free and they don't feel like waiting for calls to be dispatched from them, the can request calls themselves
  public void lookForCallFromQueue()
  {
	  callManager.assignCallToEmployee(this);
  }
 
  //setters and getters
  
  public String getEmployeeName()
  {
  	return this.fullName;
  }
  
  public boolean getAvailability()
  {
  	return this.isAvailable;
  }
  
  public int getEmployeeLevel()
  {
	  return this.level;
  }

}

