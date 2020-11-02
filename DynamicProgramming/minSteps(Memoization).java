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
    static int getMinStepsMemo(int num, int[] memo)
    {
        if(num == 1)
        {
            return 0;
        }
        
        if(memo[num] != 0)
        {
            return memo[num];
        }
        
        int result = getMinStepsMemo(num - 1, memo);
        
        if(num % 2 == 0)
        {
            result = Math.min(result, getMinStepsMemo(num/2, memo));
        }
        
        if(num % 3 == 0)
        {
            result = Math.min(result, getMinStepsMemo(num/3, memo));
        }
        
        memo[num] = result + 1;
        return memo[num];
        
    }
    

    public static void main(String[] args) 
    {
        
        System.out.println(getMinStepsMemo(100, new int[100 + 1]));
   
    }

}
