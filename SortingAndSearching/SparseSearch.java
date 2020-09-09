/* Joiney Nguyen

Given a sorted array of strings that is interspersed with empty strings, write a
method to find the location of a given string.

*/

package prac;

public class prac
{
    
    public static int sparseSearch(String[] array, String target)
    {
        //If there is an empty or null array, return -1
        if(array.length < 1 || array == null)
        {
            return -1;
        }
        
        return binarySearch(array, 0, array.length - 1, target);
    }
    
    public static int binarySearch(String[] array, int low, int high, String target)
    {
        //If low is greater than high, parameters would not be logical, so return -1
        if(low > high)
        {
            return -1;
        }
        
        int mid = (low + high) / 2;
        
        /*If mid value is blank, we make left and right points to left and right 
        side of mid and increase left by -1 and right by +1 until we find a string or either left or right exceeds boundaries
        We then use that mid value (if it's not out of boundary of low and high to compare to target
        */        
        if(array[mid] == "")
        {
            int left = mid - 1;
            int right = mid + 1;
            
            while(true)
            {
                if(left < low && right > high)
                {
                    return -1;
                }
                else if(left >= low && array[left] != "")
                {
                    mid = left;
                    break;
                }
                else if(right <= high && array[right] != "")
                {
                    mid = right;
                    break;
                }
                left--;
                right++;
            }   
        }
        
        if(target.compareTo(array[mid]) == 0)
        {
            return mid;
        }
        else if(target.compareTo(array[mid]) < 0)
        {
            return binarySearch(array, low, mid - 1, target);
        }
        else if(target.compareTo(array[mid]) > 0)
        {
            return binarySearch(array, mid + 1, high, target);
        }
        
       return -1;
    }
    
    public static void main(String[] args)
    {
       String[] array = {"At", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}; 
       
       System.out.println(sparseSearch(array, "ball"));
    }
}
