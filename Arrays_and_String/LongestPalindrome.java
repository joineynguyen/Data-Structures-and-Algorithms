/*
Joiney Nguyen

Given a string s, return the longest palindromic substring in s.

*/

class Solution 
{
    int maxLen;
    int lo;
        
    public String longestPalindrome(String s) 
    {
        if(s.length() <= 1)
        {
            return s;
        }
        
        for(int i = 0; i < s.length() - 1; i++)
        {
            insideOut(s, i, i);
            insideOut(s, i, i + 1);
        }
        
        return s.substring(lo, lo + maxLen);
    }
    
    public void insideOut(String s, int start, int end)
    {
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end))
        {
            end++;
            start--;
        }
        
        int diff = end - start - 1;
        
        if(diff > maxLen)
        {
            maxLen = diff;
            lo = start + 1;
        }
    }
}
