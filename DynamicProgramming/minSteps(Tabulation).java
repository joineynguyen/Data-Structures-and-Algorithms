/*
Enter num as starting number. Find out the minimal number steps it take to reach 1 by only using combination of :
1) subtracting num by 1
2) dividing num by 2
3) dividing num by 3
*/

package dynamicprogramming;

import java.util.Arrays;


public class DynamicProgramming 
{    
    static public int getMinStepsTab(int num)
    {
        int[] arr = new int[num + 1];
        Arrays.fill(arr, num);
        arr[1] = 0;
        
        for(int i = 1; i < num; i++)
        {
            arr[i + 1] = Math.min(arr[i + 1], arr[i] + 1);
            
            if((i * 2) <= num)
            {
                arr[i * 2] = Math.min(arr[i * 2], arr[i] + 1);
            }
            
            if((i * 3) <= num)
            {
                arr[i * 3] = Math.min(arr[i * 3], arr[i] + 1);
            }
        }
        
        return arr[num];
    }
    
    public static void main(String[] args) 
    {
        System.out.println(getMinStepsTab(100));
    }

}
