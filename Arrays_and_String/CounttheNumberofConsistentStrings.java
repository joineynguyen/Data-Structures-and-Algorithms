/*
Joiney Nguyen

Description: You are given a string allowed consisting of distinct characters and an array of strings words. A string is consistent if all characters in the string appear in the string allowed.

Return the number of consistent strings in the array words.

*/

class Solution 
{
    public int countConsistentStrings(String allowed, String[] words) 
    {
        int count = 0;
        
        outerLoop: 
        for(String word : words)
        {
            for(int i = 0; i < word.length(); i++)
            {
                if(allowed.indexOf(word.charAt(i)) == -1)
                {
                    continue outerLoop;
                }
            }
            count++;
        }
        return count;
    }
}
