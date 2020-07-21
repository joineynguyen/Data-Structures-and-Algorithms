//By: Joiney Nguyen
//Description: In a N by M matrix, whenever there is a zero, make the whole that element's whole row and column zeros as well.

import java.util.Arrays;
public class ZeroMatrix
{

	public static void zeroTheMatrix(int[][] matrix)
	{
		if(matrix.length == 0)
		{
			return;
		}
		else
		{
            int numOfRows = matrix.length;
            int numOfCols = matrix[0].length;
            
            //print out matrix before
			for(int row = 0; row < numOfRows; row++)
			{
				for(int col = 0; col < numOfCols; col++)
				{
					System.out.print(matrix[row][col]);
				}
				System.out.println();
			}
			
			 System.out.println("");


			boolean[] rowWithZero = new boolean[numOfRows];
			boolean[] colWithZero = new boolean[numOfCols];

            //find zeros in matrix
			for(int row = 0; row < numOfRows; row++)
			{
				for(int col = 0; col < numOfCols; col++)
				{
					if(matrix[row][col] == 0)
					{
						rowWithZero[row] = true;
						colWithZero[col] = true;
					}
				}
			}

            //nullify rows
			for(int i = 0; i < rowWithZero.length; i++)
			{
				if(rowWithZero[i] == true)
				{
				    nullifyRows(matrix, i);
				}
			}

			for(int i = 0; i < colWithZero.length; i++)
			{
				if(colWithZero[i] == true)
				{
				    nullifyCols(matrix, i);
				}
			}


			for(int row = 0; row < numOfRows; row++)
			{
				for(int col = 0; col < numOfCols; col++)
				{
					System.out.print(matrix[row][col]);
				}
				System.out.println();
			}

		}

	}

    public static void nullifyRows(int[][] matrix, int row)
    {
        for(int i = 0; i < matrix[0].length; i++)
        {
            matrix[row][i] = 0;
        }
    }
    
     public static void nullifyCols(int[][] matrix, int col)
    {
        for(int i = 0; i < matrix.length; i++)
        {
            matrix[i][col] = 0;
        }
    }


	public static void main(String[] args)
	{
		int[][] array = {{1,2,0},
						 {4,0,6},
						 {7,8,9}};


       
		zeroTheMatrix(array);
		
		
	}
}