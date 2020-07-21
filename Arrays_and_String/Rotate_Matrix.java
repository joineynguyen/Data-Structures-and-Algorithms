//By: Joiney Nguyen
//Description: Rotate N x N matrix clockwise.

import java.util.Arrays;

public class RotateMatrix
{

	public static void rotate90(int[][] matrix)
	{
		if(matrix.length == 0 || matrix.length != matrix[0].length)
		{
			System.out.println("Matrix is not N by N");
			return;
		}
		else
		{
			int n = matrix.length;
	

			for(int i = 0; i < n; i++)
			{
				for(int j = i; j < n; j++)
				{
					int temp = matrix[i][j];

					matrix[i][j] = matrix[j][i];

					matrix[j][i] = temp;
				}
			}

            for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < (n/2); j++)
				{
					int temp = matrix[i][j];
					matrix[i][j] = matrix[i][n - 1 - j];
					matrix[i][n-1-j] = temp;
				}
			}
		

			for(int i = 0; i < n; i++)
			{
				for(int j = 0; j < n; j++)
				{
					System.out.print(matrix[i][j]);
				}
				System.out.println();
			}

		}


		    
	}

		


	public static void main(String[] args)
	{
	    int[][] intArray = new int[][] { {1,2,3}, 
	                                     {4,5,6}, 
	                                     {7,8,9} };

		rotate90(intArray);
		
		
	}
}