import java.util.*;

public class NodeNew{
	public ArrayList<NodeNew> frontier;
	public int id;

	public NodeNew(int id, ArrayList<NodeNew> frontier){
		this.id = id;
		this.frontier = frontier;
	}

	@Override
	public boolean equals(Object other){
		if (!(other instanceof NodeNew)) return false;
		
		NodeNew o = (NodeNew) other;
	
		//we assume that graphs have unique names for their node	
		return this.id == o.id;
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(id);
	}

	@Override
	public String toString(){
		return " " + id;
	}
}

