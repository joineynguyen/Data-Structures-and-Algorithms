//By: Joiney Nguyen
//Description: Check if string is palindrome.

import java.util.Arrays;
public class MyClass
{

	public static boolean isPalindrome(String str)
	{
		int size = str.length();

		int[] intArray = new int[size];

		int indexHashed;

		for(int i = 0; i < size; i ++)
		{
			char currentChar = str.charAt(i);

			if(Character.isLetter(currentChar))
			{
				currentChar = Character.toLowerCase(currentChar);
				indexHashed = Character.getNumericValue(currentChar) % size;

				intArray[indexHashed]++;
			}
			else if(currentChar == ' ')
			{
				continue;	
			}
			else
			{
				return false;
			}

		
		}

		int oddCount = 0;

		for(int j = 0; j < intArray.length; j++)
		{
			if((intArray[j] % 2) == 1)
			{
				oddCount++;
			}
			
		}

		if(oddCount > 1)
		{
			return false;
		}
		else
		{
			return true;
		}


	}

	public static void main(String[] args)
	{
		String str = "abcdefghijklmnopqrstuvwxyz abcdefghijklmnopqrstuvwxyz";

		System.out.println(isPalindrome(str));
	}
}