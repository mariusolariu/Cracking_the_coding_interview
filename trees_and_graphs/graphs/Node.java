import java.util.*;

public class Node{
	public ArrayList<Node> frontier;
	public String name;

	public Node(String name, ArrayList<Node> frontier){
		this.name = name;
		this.frontier = frontier;
	}

	@Override
	public boolean equals(Object other){
		if (!(other instanceof Node)) return false;
		
		Node o = (Node) other;
	
		//we assume that graphs have unique names for their node	
		return this.name.equals(o.name);
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(name);
	}

	@Override
	public String toString(){
		return " " + name;
	}
}

