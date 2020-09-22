/*
Joiney Nguyen

Design a data structure that is initialized with a list of different words. Provided a string, you should determine if you can change exactly one character in this string to match any word in the data structure.

Implement the MagicDictionary class:

MagicDictionary() Initializes the object.
void buildDict(String[] dictionary) Sets the data structure with an array of distinct strings dictionary.
bool search(String searchWord) Returns true if you can change exactly one character in searchWord to match any string in the data structure, otherwise returns false.
 

Example 1:

Input
["MagicDictionary", "buildDict", "search", "search", "search", "search"]
[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
Output
[null, null, false, true, false, false]

Explanation
MagicDictionary magicDictionary = new MagicDictionary();
magicDictionary.buildDict(["hello", "leetcode"]);
magicDictionary.search("hello"); // return False
magicDictionary.search("hhllo"); // We can change the second 'h' to 'e' to match "hello" so we return True
magicDictionary.search("hell"); // return False
magicDictionary.search("leetcoded"); // return False
*/


//For the most part, this code works but if there are hello and hallo in the dictionary and you search hallo, it will return false even though u can change one letter to turn it to hello
class MagicDictionary 
{
    TrieNode root;
    /** Initialize your data structure here. */
    public MagicDictionary() 
    {
        root = new TrieNode();
    }
    
    class TrieNode
    {
        TrieNode[] children;
        boolean isWord;
        
        public TrieNode()
        {
            children = new TrieNode[26];
            isWord = false;
            
            for(int i = 0; i < 26; i++)
            {
                children[i] = null;
            }
        }
    }
    
    
    public void buildDict(String[] dictionary) 
    {
        for(String s : dictionary)
        {
            TrieNode current = root;
            
            for(int i = 0; i < s.length(); i++)
            {
                int index = s.charAt(i) - 'a';
                
                if(current.children[index] == null)
                {
                    current.children[index] = new TrieNode();
                }
                current = current.children[index];
            }
            current.isWord = true;
        }
    }
    
    public boolean search(String searchWord) 
    {
        TrieNode current = root;
        
        for(int i = 0; i < searchWord.length(); i++)
        {
            int index = searchWord.charAt(i) - 'a';
            if(current.children[index] == null)
            {
                return searchHelper(searchWord, i, current);
            }
            current = current.children[index];
        }
        return false;
    }
    
    public boolean searchHelper(String searchWord, int stringPos, TrieNode node)
    {
        TrieNode current;
        int i = 0;
        
        while(i < 26)
        {
            current = node;
            
            if(current.children[i] == null)
            {
                i++;
                continue;
            }
            else if(current.children[i] != null)
            {
                current = current.children[i];
            }
            
            for(int j = stringPos + 1; j < searchWord.length(); j++)
            {
                int index = searchWord.charAt(j) - 'a';
                
                if(current.children[index] == null)
                {
                    break;
                }
                else
                {
                    current = current.children[index];
                }
                
            }
            
            if(current.isWord == true)
            {
                return true;
            }
            
            i++;
        }
        
        return false;
    }
    
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
