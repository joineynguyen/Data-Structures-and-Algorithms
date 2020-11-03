/*
Joiney Nguyen

A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
*/

package dynamicprogramming;

public class TripleStep
{
    //Tabulation method
    static void getNStepsTab(int num)
    {
        int[] arr = new int[num + 1];
        
        arr[0] = 1;
        
        for(int i = 0; i < num; i++)
        {
            arr[i + 1] = arr[i + 1] + arr[i];
            
            if(i + 2 <= num)
            {
                arr[i + 2] = arr[i + 2] + arr[i];
            }
            
            if(i + 3 <= num)
            {
                arr[i + 3] = arr[i + 3] + arr[i];
            }
        }
        
        System.out.println(arr[num]);
    }
    
    static void getNStepsMemo(int num)
    {
        System.out.println(nStepsMemo(num, new int[num + 1]));
    }
    
    //Memoization method
    static int nStepsMemo(int num, int[] memo)
    {
        if(num == 0)
        {
            return 1;
        }
        
        if(memo[num] != 0)
        {
            return memo[num];
        }
        
        int result = nStepsMemo(num - 1, memo);
        
        if(num - 2 >= 0)
        {
            result = result + nStepsMemo(num - 2, memo);
        }
        
        if(num - 3 >= 0)
        {
            result = result + nStepsMemo(num - 3, memo);
        }
        
        memo[num] = result;
        return memo[num];
        
    }
    
    static void getNSteps(int num)
    {
        System.out.println(nSteps(num));
    }
    
    //Brute force recursion
    static int nSteps(int num)
    {
        if(num == 0)
        {
            return 1;
        }
        
        int result = nSteps(num - 1);
        
        if(num - 2 >= 0)
        {
            result = result + nSteps(num - 2);
        }
        
        if(num - 3 >= 0)
        {
            result = result + nSteps(num - 3);
        }
        
        return result;
    }
    
    public static void main(String[] args)
    {
        getNSteps(4);
        getNStepsMemo(4);
        getNStepsTab(4);
    }
}
