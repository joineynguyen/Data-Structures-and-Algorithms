package myPackage;

//object for each phone call
public class Call
{
  /*calls will initially be set to 0. if respondents can't handle the call, they can escalate it to the managers
  , which then will increment the level to 1. Then if the managers can't handle the call, they can escalate it to
  a director, which then increment the level to 2. The levels also represents the element these respected positions are in 
  an arraylist of arraylists with employees called 'employeeLevels'. This makes it easier to access the right array list.
  */
  private int level;
  //customer who called
  private Caller caller;
  //employee handling the call
  private Employee callHandler;

  public Call(Caller caller)
  {
	  this.level = 0;
	  this.caller = caller;
  }
  
  //another constructor in case we know the call level beforehand
  public Call(Caller caller, int level)
  {
	  this.level = level;
	  this.caller = caller;
  }
  
  
  //getters and setters
  public void incrementLevel()
  {
  	this.level += 1;
  }
  
  public int getCallLevel()
  {
  	return this.level;
  }
  
  public void setCallHandler(Employee employee)
  {
  	this.callHandler = employee;
  }
  
  public String getCallerName()
  {
	  return caller.getCallerName();
  }
  
  
}