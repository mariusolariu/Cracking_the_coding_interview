import java.util.*;

public class Sol{

	public void visit(Node root){

	}

	public void printPath(ArrayList<Integer> path){
		
		System.out.println("Path:");
		for (Integer p : path){
			System.out.print(" " + p);
		}
	}

	//TODO: modify the path with a queue
	public void findPath(Node currentNode, Node destination, ArrayList<Integer> path, boolean[] visited){

		if ((currentNode == null) || (destination == null)) return;

		path.add(currentNode.id);
 		visited[currentNode.id] = true;

		if (currentNode.equals(destination)){
			printPath(path);
		}

		for (Node n : currentNode.frontier){
			
			//find a more elegant way to emulate the stack for path
			if (visited[n.id] == false) findPath(n, destination, new ArrayList<Integer>(path), visited);
		}			

		path.remove(currentNode);

	}

	public static void main(String[] args){

	}

}

