//By: Joiney Nguyen
//Description: Displace the current letter in the string follow by the number of that character will be after the current character.

public class MyClass
{
	public static String stringCompressor(String str)
	{
		char currentChar;
		int currentCharCount;
		StringBuilder sb = new StringBuilder();

		int index1 = 0;
		int index2 = 0;

		while(index1 < str.length())
		{
			currentCharCount = 0;
			currentChar = str.charAt(index1);
			currentCharCount ++;

			index2 = index1 + 1;

			while(index2 < str.length())
			{
				if(str.charAt(index1) != str.charAt(index2))
				{
					break;
				}

				currentCharCount ++;
				index2 ++;
			}

			index1 = index2;

			sb.append(currentChar);
			sb.append(currentCharCount);

		}

		return sb.toString();

	}



	public static void main(String[] args)
	{
		String str = "sstfuuuuuu";

		System.out.println(stringCompressor(str));
	}
}