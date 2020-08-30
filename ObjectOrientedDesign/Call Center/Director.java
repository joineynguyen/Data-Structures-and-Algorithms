package myPackage;

//Notice director has no function to escalate call because they are the highest level
public class Director extends Employee
{
  final String position = "Director";
   
  public Director(int employeeID, String fullName, CallManager callManager) 
  {
	  super(employeeID, fullName, callManager);
      this.level = 2;
  }

}