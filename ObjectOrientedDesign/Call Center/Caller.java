package myPackage;

//client
public class Caller
{
  private String callerName;
  private int callerNumber;
  
  public Caller(String callerName, int callerNumber)
  {
	  this.callerName = callerName;
	  this.callerNumber = callerNumber;
  }
  
  public String getCallerName()
  {
	  return this.callerName;
  }
  
  public int getCallerNumber()
  {
	  return this.callerNumber;
  }
  
  //In case the caller wants to change their name in our system
  public void setCallerName(String callerName)
  {
	  this.callerName = callerName;
  }
}