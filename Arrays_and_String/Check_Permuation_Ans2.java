//By: Joiney Nguyen
//Description: check if two string are permutations of another.

import java.util.Arrays;
public class MyClass
{

	public boolean isPermutation(String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			return false;
		}

		int[] characters = new int[128];

		for(int i = 0; i < str1.length(); i++)
		{
			int currentChar = str1.charAt(i);
			characters[currentChar]++;
		}

		for(int j = 0; j < str2.length(); j++)
		{
			int currentChar2 = str2.charAt(j);
			characters[currentChar2]--;

			if(characters[currentChar2] < 0)
			{
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args)
	{
		String str1 = "!@#";
		String str2 = "#@!";
    
        MyClass mym = new MyClass();
		System.out.println(mym.isPermutation(str1, str2));
	}
}