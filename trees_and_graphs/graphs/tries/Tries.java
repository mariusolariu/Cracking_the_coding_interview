import java.util.*;

public class Tries{

	public void addWord(TrieNode n, String word){
	
		TrieNode current = n;	
		for (int i=0; i<word.length(); i++){
			char nextChar = word.charAt(i);
			TrieNode toAdd = new TrieNode(nextChar);

			current = current.addChildren(toAdd);
			
		}	

		//add the mark for a final node
		TrieNode finalNode = new TrieNode('*');
		current.addChildren(finalNode);
	}

	/* pass the root of the trie
	*/
	public boolean isWordInTrie(Node root, String word){
		TrieNode result = searchPrefix(root, word);
		
		return result != null;
	}

	//return a refernce to the node where prefix ends
	public TrieNode searchPrefix(TrieNode n, String prefix){
		TrieNode result = null;
		
		int i;
		TrieNode current = n;
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
	public void printGraph(TrieNode n){
		Queue<TrieNode> queue = new LinkedList<>();

		queue.add(n);
		
		while (!queue.isEmpty()){
			TrieNode head = queue.poll();

			//print children
			
			System.out.print(head.getChildren().size() + " " + head + ": ");
			for (TrieNode t : head.getChildren()){
				System.out.print(t + " ");
				queue.add(t);
			}

			System.out.println();
		}

	}

	public static void main(String[] args){
		TrieNode root = new TrieNode('#');

		String w1 = "marius";
		String w2 = "mmari";
		String w3 = "mmmaf";
		String w4 = "mariua";
		String w5 = "mariu";
	
		Tries t = new Tries();
		t.addWord(root, w1);
		t.addWord(root, w2);
		t.addWord(root, w3);
		t.addWord(root, w4);

		TrieNode u = t.searchPrefix(root, w5);
		System.out.println("\n" + u.getChildren());

		t.printGraph(root);

		TrieNode exists = t.searchPrefix(root, w1);
		System.out.println(exists.getChildren().get(0).getChar());

	}
}
