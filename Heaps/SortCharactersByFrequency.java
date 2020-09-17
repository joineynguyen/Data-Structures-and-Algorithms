/*
Joiney Nguyen

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/

import java.util.HashMap;
import java.lang.StringBuilder;
import java.util.PriorityQueue;

class Solution 
{
    public String frequencySort(String s) 
    {
        //To keep track of how many times we come across a character
        HashMap<Character, Integer> map = new HashMap<>();
        
        //We increment the value of char keys by 1 every time we come across it in the string s... if there is no value, we set it to 0 first the increment
        for(char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        //Queue that stores map entries (char + integer set)... sort it by difference in value with descending order.. normally, a - b difference gives u min heap by default so we flip to b - a
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());
        
        //we add all entries from map to queue with addAll function and input map.entrySet()
        pq.addAll(map.entrySet());
        
        //Helps us form a string 
        StringBuilder sb = new StringBuilder();
        
        //While the queue is not empty, we go through each map set (char + integer) and we add to string builder the char as many times as their value is... C - 3 would add 3 C's
        while(!pq.isEmpty())
        {
            Map.Entry e = pq.poll();
            
            for(int i = 0; i < (int)e.getValue(); i++)
            {
                sb.append(e.getKey());
            }
        }
        
        return sb.toString();
    }
}
