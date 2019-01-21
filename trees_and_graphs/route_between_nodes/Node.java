import java.util.*;

public class Node{
	public ArrayList<Node> frontier;
	public int id;

	public Node(int id , ArrayList<Node> frontier){
		this.id = id;
		this.frontier = frontier;
	}

	@Override
	public boolean equals(Object other){
		if (!(other instanceof Node)) return false;
		
		Node o = (Node) other;
	
		//we assume that graphs have unique names for their node	
		return this.id == o.id;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(this.id);
	}
}

