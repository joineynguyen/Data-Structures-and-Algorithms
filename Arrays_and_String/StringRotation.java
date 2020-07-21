//By: Joiney Nguyen
//Description: Check if the string are the same, even though one may start from a different index

import java.util.Arrays;

public class StringRotation
{



	public static boolean isRotation(String str1, String str2)
	{
		if(str1.length() > 0 && str1.length() == str2.length())
		{
			String s1s1 = str1 + str1;
			return s1s1.contains(str2);
		}
			
		return false;
	}


	public static void main(String[] args)
	{
		String str1 = "terbottlewa";
		String str2 = "waterbottle";
		System.out.print(isRotation(str1, str2));
	}
}