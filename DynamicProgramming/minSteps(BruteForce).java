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

    static int getMinSteps(int num)
    {
        if(num == 1)
        {
            return 0;
        }
        
        int result = getMinSteps(num - 1);
        
        if(num % 2 == 0)
        {
            result = Math.min(result, getMinSteps(num / 2));
        }
        
        if(num % 3 == 0)
        {
            result = Math.min(result, getMinSteps(num / 3));
        }
        
        return result + 1;
    }
    
    public static void main(String[] args) 
    {
        System.out.println(getMinSteps(100));
      
    }

}
