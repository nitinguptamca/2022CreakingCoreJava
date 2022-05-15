package com.datastructure.Trie;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	private Node root;
	
	public Trie() {
		// representing the empty string
		root = new Node("");
	}
	
	public List<String> sort() {
		return autocomplete("");
	}
	
	public List<String> autocomplete(String prefix) {
		
		Node trieNode = root;
		List<String> autocompleteList = new ArrayList<>();
		
		// first we have to consider the letters of the prefix
		for(int i = 0;i<prefix.length();++i) {
			char c = prefix.charAt(i);
			int asciiIndex = c-'a';
			
			if(trieNode.getChild(asciiIndex) == null)
				return autocompleteList;
				
			trieNode = trieNode.getChild(asciiIndex);
		}
		
		// this is the in-order traversal (DFS)
		collect(trieNode, prefix, autocompleteList);
		
		return autocompleteList;
	}
	
	private void collect(Node node, String prefix, List<String> list) {
		
		// base-case
		if(node==null) return;
		
		// when we hit  leaf node
		if(node.isLeaf())
			list.add(prefix);
		
		// all the children of the actual node (node=letter)
		for(Node childNode : node.getChildren()) {
			if(childNode == null) continue;
			String childCharacter = childNode.getCharacter();
			// depth-first search
			collect(childNode, prefix+childCharacter,list);
		}
	}

	public void insert(String key) {
		
		Node tempNode = root;
	
		// we have to consider all the letters in the key
		for(int i=0;i<key.length();++i) {
			// this is how we get the letter at the given index
			char c = key.charAt(i);
			// we have to deal with ASCII values
			// in our ASCII table the first letter is 'a'
			int asciiIndex = c - 'a';
			
			// we have to check whether the given letter is already
			// a children of the given node
			if (tempNode.getChild(asciiIndex) == null) {
				Node node = new Node(String.valueOf(c));
				tempNode.setChild(asciiIndex, node);
				tempNode = node;
			} else {
			// the node with the given letter is already a child
				tempNode = tempNode.getChild(asciiIndex);
			}
		}
		
		tempNode.setLeaf(true);	
	}
	
	public boolean search(String key) {
		
		Node tempNode = root;

		for(int i=0;i<key.length();++i) {
			// this is how we get the letter at the given index
			char c = key.charAt(i);
			// we have to deal with ASCII values
			// in our ASCII table the first letter is 'a'
			int asciiIndex = c - 'a';
			
			if (tempNode.getChild(asciiIndex) == null) {
				// search miss as the letter with index (asciiIndex) is not present in the trie
				return false;
			} else {
				// because the given node exists in the trie
				tempNode = tempNode.getChild(asciiIndex);
			}
		}
		
		if(!tempNode.isLeaf()) return false;
		
		return true;
	}
}
