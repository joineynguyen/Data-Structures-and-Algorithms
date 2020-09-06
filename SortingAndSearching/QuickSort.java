package practice;

public class Prac
{
     public static void quickSort(int[] arr, int lb, int ub) 
    {
        //check for empty or null array
        if (arr == null || arr.length == 0){
            return;
        }
         
        if (lb >= ub){
            return;
        }
        
        int temp;
        //Get the pivot element from the middle of the list
        int middle = lb + (ub - lb) / 2;
        int pivot = arr[middle];
 
        // make left < pivot and right > pivot
        int start = lb, end = ub;
        while (start <= end) 
        {
            //Check until all values on left side array are lower than pivot
            while (arr[start] < pivot) 
            {
                start++;
            }
            //Check until all values on left side array are greater than pivot
            while (arr[end] > pivot) 
            {
                end--;
            }
            //Now compare values from both side of lists to see if they need swapping 
            //After swapping move the iterator on both lists
            if (start <= end) 
            {
                temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                
                start++;
                end--;
            }
        }
        //Do same operation as above recursively to sort two sub arrays
        if (lb < end){
            quickSort(arr, lb, end);
        }
        if (ub > start){
            quickSort(arr, start, ub);
        }
    }
    
    static void print(int[] array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.print(array[i] + " ");
        }
    }
    
    public static void main(String[] args)
    {
        int[] array = {7, 6, 10, 5, 9, 1, 15, 7};
        
        quickSort(array, 0, array.length - 1);
        print(array);
    }
    
}
