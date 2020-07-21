//By: Joiney Nguyen
//Description: Check if the two strings are only ONE edit away.

public class MyClass
{
	
	public static boolean isOneEdit(String str1, String str2)
	{
		if(str1.length() == str2.length())
		{
			return oneReplaced(str1, str2);
		}
		else if((str1.length() + 1) == str2.length())
		{
			return oneInserted(str1, str2);
		}
		else if((str1.length() - 1) == str2.length())
		{
			return oneInserted(str2, str1);
		}
		
		return false;
	}

	public static boolean oneReplaced(String str1, String str2)
	{
		boolean foundDifference = false;

		for(int i = 0; i < str1.length(); i++)
		{
		
			if(str1.charAt(i) != str2.charAt(i))
			{
				if(foundDifference == true)
				{
					return false;
				}
				
				foundDifference = true;
			}
		}

		return true;
	}

	public static boolean oneInserted(String str1, String str2)
	{
		int indexStr1 = 0;
		int indexStr2 = 0;
		boolean skippedChar = false;

		while(indexStr1 < str1.length() && indexStr2 < str2.length())
		{
			if(str1.charAt(indexStr1) == str2.charAt(indexStr2))
			{
				indexStr1 ++;
				indexStr2 ++;
			}
			else if(str1.charAt(indexStr1) != str2.charAt(indexStr2))
			{
				if(skippedChar == true)
				{
					return false;
				}

				indexStr2 ++;
				skippedChar = true;

			}
		}

		return true;
	}


	public static void main(String[] args)
	{
		String str1 = "pale";
		String str2 = "bake";

		System.out.println(isOneEdit(str1, str2));
	}
}