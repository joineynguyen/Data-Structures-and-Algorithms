/*
Joiney Nguyen

Trie implementation with search, insert, and delete methods

*/

public class Trie
{
	private class TrieNode
	{
		boolean endOfWord;
		HashMap<Character, TrieNode> children;

		public TrieNode()
		{
			endOfWord = false;
			children = new HashMap<>();
		}

	}

	TrieNode root;

	public Trie()
	{
		root = new TrieNode();
	}

	public void insertWord(String word)
	{
		TrieNode current = root;

		for(int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			TrieNode node = current.children.get(c);

			if(node == null)
			{
				node = new TrieNode();
				current.children.put(c, node);
				
			}

			current = node;
		}

		current.endOfWord = true;
	}

	public boolean searchWord(String word)
	{
		TrieNode current = root;

		for(int i = 0; i < word.length(); i++)
		{
			char c = word.charAt(i);
			TrieNode node = current.children.get(c);
			if(node == null)
			{
				return false;
			}
			current = node;
		}
		return current.endOfWord;
	}

	public boolean deleteWord(String word)
	{
		deleteWord(word, 0, root);
	}

	public boolean deleteWord(String word, int index, TrieNode current)
	{
		if(index == word.length())
		{
			if(current.enfOfWord == false)
			{
				return false;
			}

			current.endOfWord = false;

			return current.children.size() == 0;
		}

		char c = word.charAt(index);
		TrieNode node = current.children.get(c);

		if(node == null)
		{
			return false;
		}

		boolean shouldDeleteCurrentNode = delete(word, index + 1, node);

		if(shouldDeleteCurrentNode)
		{
			current.children.remove(c);
			return current.children.size() == 0;
		}

		return false;
	}



}
