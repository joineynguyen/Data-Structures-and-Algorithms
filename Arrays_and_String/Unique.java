//By: Joiney Nguyen
//Description: Program decides if string has unique characters

import java.util.Arrays;

public class MyClass
{

	public static void main(String[] args)
	{
		//boolean array to keep track of characters reviewed
		boolean[] theArray = new boolean[128];

		String test = "!@#$%^&*()_+";

		//if statement since strings with length over 128 cannot be unique
		if(test.length() > 128)
		{
			System.out.println("Not unique.");
		}
		else
		{
			for(int i = 0; i < test.length(); i++)
			{
				int val = test.charAt(i);

				//if index of array, relating to character, already true... then return since no longer unique.
				if(theArray[val])
				{
					System.out.println("Not unique.");
					return;
				}
				//flag index of array relating to character true if passes for first time
				else
				{
					theArray[val] = true;
				}
			}
			System.out.println("Unique.");
		}

	
	}
}