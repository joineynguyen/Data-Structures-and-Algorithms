/*
Joiney Nguyen

Given an M x N matrix in which each row and each column is sorted in
ascending order, write a method to find an element.
*/

package prac;

public class prac
{
    public static void findElement(int[][] matrix, int element)
    {
        if(matrix == null || matrix.length < 1)
        {
            return;
        }
        
        matrixBinarySearch_Row(matrix, element);
      
    }
    
    //We search through each row to see if element is in that row or smaller/bigger than that row
    public static void matrixBinarySearch_Row(int[][] matrix, int element)
    {
        
        int start_row = 0;
        int end_row = matrix.length - 1;
        
        while(start_row <= end_row)
        {
            int mid_row = (start_row + end_row) / 2;
        
            //Element in row
            if(compareElementToCurrentRow(matrix, mid_row, element) == 0)
            {
                matrixBinarySearch_Col(matrix, mid_row, element);
                return;
                
            }
            //Element smaller than row 
            else if(compareElementToCurrentRow(matrix, mid_row, element) == 1)
            {
                end_row = mid_row - 1;
            }
            //Element larger than row
            else if(compareElementToCurrentRow(matrix, mid_row, element) == 2)
            {
                start_row = mid_row + 1;
            }
        }

        System.out.println("Element not found.");    
    }  
        
    
    //returns position of element relating to current row 
    //(e.g., 0 = element in row, 1 = element smaller than row, 2 = element bigger than row
    public static int compareElementToCurrentRow(int[][] matrix, int row, int element)
    {
        int col_end = matrix[row].length - 1;
        
        if(element >= matrix[row][0] && element <= matrix[row][col_end])
        {
            return 0;
        }
        else if(element < matrix[row][0])
        {
            return 1;
        }
        else if(element > matrix[row][col_end])
        {
            return 2;
        }
        
        return -1;
    }
    
    //Performs binary search on columns in current row
    public static void matrixBinarySearch_Col(int[][] matrix, int row, int element)
    {
        int start_col = 0;
        
        int end_col = matrix[row].length - 1;
        
        while(start_col <= end_col)
        {
            int mid_col = (start_col + end_col) / 2;

            if(element == matrix[row][mid_col])
            {
                System.out.println("Element " + element + " found at " + row + "," + mid_col);
                return;
                
            }
            else if(element < matrix[row][mid_col])
            {
                end_col = mid_col - 1;
            }
            else if(element > matrix[row][mid_col])
            {
                start_col = mid_col + 1;
            }
        }
        System.out.println("Element not found.");
    }
    
    public static void main(String[] args)
    {
        int M = 10;
        int N = 5;
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) 
        {
            for (int j = 0; j < N; j++) 
            {
                    matrix[i][j] = 10 * i + j;
            }
        }
        
        for(int i = 0; i < M; i ++)
        {
            for(int j = 0; j < N; j++)
            {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        
        findElement(matrix, 94);
       
    }
    
}
