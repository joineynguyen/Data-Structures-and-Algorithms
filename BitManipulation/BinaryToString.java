/*	Joiney Nguyen
	
	Given a real number between 0 and 1 (e.g., 0.72) that is passed in as a double, print
	the binary representation. If the number cannot be represented accurately in binary with at most 32
	characters, print "ERROR:'

*/

public class Solution
{

	String printToBinary(double num)
	{
		if(num >= 1 || num <= 0)
		{
			return "ERROR";
		}

		StringBuilder sb = new StringBuilder();

		while(num > 0)
		{
			if(sb.length() > 32)
			{
				return "ERROR";
			}

			num = num * 2;

			if(num >= 1)
			{
				sb.append(1);
				num = num - 1;
			}
			else
			{
				sb.append(0);
			}
		}

		return sb.ToString();
	}

}
