import java.util.*;

public class Node{
	private String name;
	private ArrayList<Node> children;

	public Node(String name, ArrayList<Node> children){
		this.name = name;
		this.children = children;
	}

	public Node(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public ArrayList<Node> getChildren(){
		return children;
	}

}

