import java.util.*;
/**
 *	'#' represents the root
 *	'*' represents that is a final node (the path leading to it represents a word)
 */
public class TrieNode{
	private char c;
	private ArrayList<TrieNode> children;

	private TrieNode(){}

	public TrieNode(char c){
		this.c = c;
		children = new ArrayList<>();
	} 

	/** adds the other node as a child if it doesnt exist and returns it or returns the node if it exists
	*/
	public TrieNode addChildren(TrieNode other){
		TrieNode result = null;

		int i = children.indexOf(other);

		if (i != -1){
			result = children.get(i);
		}else{
			children.add(other);
			result = other;
		}

		return result;
	}


	public ArrayList<TrieNode> getChildren(){
		return children;
	}

	public char getChar(){
		return c;
	}

	@Override
	public boolean equals(Object o){
		if (o == this) return true;

		if (!(o instanceof TrieNode)) return false;

		TrieNode other = (TrieNode) o;

		return this.c == other.getChar();
	}


	@Override
	public int hashCode(){
		return Objects.hash(c);
	}


	@Override
	public String toString(){
		return String.valueOf(c);
	}
		
}
