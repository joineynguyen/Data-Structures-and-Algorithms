//By: Joiney Nguyen
//Description: See if two strings are permutatoins of another.
public class MyClass
{
	
	public void sameLetters(String str1, String str2)
	{
		if(str1.length() != str2.length())
		{
			System.out.println("Is not a permutation of another.");
		}
		else
		{
			char[] charArray1 = str1.toCharArray();
			char[] charArray2 = str2.toCharArray();
			Arrays.sort(charArray1);
			Arrays.sort(charArray2);

			if(Arrays.equals(charArray1, charArray2))
			{
				System.out.println("Is permutation.");
			}
			else
			{
				System.out.println("Is NOT permutation.");
			}

		}

	}


	public static void main(String[] args)
	{
		String str1 = "hello";
		String str2 = "olleh";

		sameLetters(str1,str2);


	}
}