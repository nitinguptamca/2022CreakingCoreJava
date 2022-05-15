package com.datastructure.Trie;

public class App {

	public static void main(String[] args) {
		
		Trie trie = new Trie();
		trie.insert("daniel");
		trie.insert("justin");
		trie.insert("adam");
		trie.insert("michael");
		trie.insert("anna");
		trie.insert("kevin");

		
		for(String s : trie.sort())
			System.out.println(s);
	}
}
