/*
Joiney Nguyen

Trie implementation with search and insert functions
*/

public class Trie
{
	final int ALPHABET_NUM = 26;

	class TrieNode
	{
		TrieNode[] = children;
		boolean endOfWord;
		String word;

		public TrieNode()
		{
			children = new TrieNode[ALPHABET_NUM];
			endOfWord = false;
			word = "";

			for(int i = 0; i < ALPHABET_NUM; i++)
			{
				children[i] = null;
			}
		}
	}

	TrieNode root;

	public TrieNode()
	{
		root = new TrieNode();
	}

	public void insert(String word)
	{
		TrieNode current = root;

		for(int i = 0; i < word.length(); i++)
		{
			int index = word.charAt(i) - 'a';
			if(current.children[index] == null)
			{
				current.children[index] = new TrieNode();
			}
			node = current.children[index];
		}
		node.endOfWord = true;
		node.word = word;
	}

	public boolean search(String word)
	{
		TrieNode current = root;

		for(int i = 0; i < word.length(); i++)
		{
			int index = word.charAt(i);
			if(current.children[index] == null)
			{
				return false;
			}
			current = current.children[index];
		}
		return true;
	}




}
