package tries;

import java.util.*;

public class Trie{
	private TrieNode root;

	public Trie(){
		root = new TrieNode('#');
	}

	public TrieNode addWord(String word){
	
		TrieNode current = root;	
		for (int i=0; i<word.length(); i++){
			char nextChar = word.charAt(i);
			TrieNode toAdd = new TrieNode(nextChar);
			
			int index;

			if ( (index = current.getChildren().indexOf(toAdd)) != -1 ){
				current = current.getChildren().get(index);
			}else{
				current = current.addChildren(toAdd);
			}
		}	

		TrieNode finalNode;
		//add the mark for a final node
		if (current.getChildren().size() == 0){
			 finalNode = new TrieNode('*');
		}else{
			finalNode = current.getChildren().get(0);
		}

		current.addChildren(finalNode);
		finalNode.increaseWordFrequency();

		return finalNode;
	}

	/* pass the root of the trie
	*/
	public boolean isWordInTrie(String word){
		TrieNode result = searchPrefix(word);
		
		return result != null;
	}

	//return a refernce to the node where prefix ends
	public TrieNode searchPrefix(String prefix){
		TrieNode result = null;
		
		int i;
		TrieNode current = root;
		for (i=0;  i < prefix.length(); i++){
				char c = prefix.charAt(i);
				
				int j = current.getChildren().indexOf(new TrieNode(c));
				if (j != -1){
					current = current.getChildren().get(j); //move downward
				}else{
					break; //the prefix isnt in this trie
				}
		}

		
		if (i == prefix.length()){
			result = current;
		}
	

		return result;
	}
	
	//a breadth first search manner
	public void printGraph(){
		Queue<TrieNode> queue = new LinkedList<>();

		queue.add(root);
		
		while (!queue.isEmpty()){
			TrieNode head = queue.poll();

			//print children
			
			System.out.print(head.getChildren().size() + " " + head + ": ");

			if (head.getChar() == '*') System.out.print(head.getWordFrequency());

			for (TrieNode t : head.getChildren()){
				System.out.print(t + " ");
				queue.add(t);
			}

			System.out.println();
		}

	}

	public static void main(String[] args){
	}
}
