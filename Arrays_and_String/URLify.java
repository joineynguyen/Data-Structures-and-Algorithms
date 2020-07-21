//By: Joiney Nguyen
//Description: Place "%20" where spaces are in the string. 
import java.util.Arrays;

public class MyClass
{
	
	public static String URLify(String str)
	{	
		
		str = str.trim();

		str = str.replace(" ", "%20");

		return str;


	}


	public static void main(String[] args)
	{
		String str = "Mr John Smith";

		String ans = URLify(str);
		
		System.out.println(ans);
	}
}