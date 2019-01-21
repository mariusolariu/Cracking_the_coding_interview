import java.util.*;

public class GraphSearch{

	public void operation(Node n){
		System.out.println(" " + n.name);
	}

	public boolean breadthFirstSearch(Node root, Node searched, boolean[] visitedNodes){
		if ((root == null) || (searched == null)) return false;

		boolean result = false;
		
		Queue<Node> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);

		while (!nodesQueue.isEmpty()){
			Node head = nodesQueue.poll();
			int index = Integer.valueOf(head.name);
			visitedNodes[index] = true;

			//perform operation on head
			System.out.println(" " + head);
			if (head.equals(searched)) return true;

			for (Node f : head.frontier){
				int j  = Integer.valueOf(f.name);

				if (visitedNodes[j] == false) nodesQueue.add(f);
			}
			
		}		

		return false;
	}

	public boolean depthFirstSearch(Node n, Node searched, boolean[] visitedNodes){
		
		if ((n == null) || (searched == null)) return false;
		
		boolean result = false;
		
		int index = Integer.valueOf(n.name);
		visitedNodes[index] = true;

		//do some operation on this node data
		System.out.println(" " + n.name);
		if (n.equals(searched)) return true;

		for (Node f : n.frontier){
			int j = Integer.valueOf(f.name);

			if (visitedNodes[j] == false)  result = depthFirstSearch(f, searched, visitedNodes);			
		}

		return result;
	}


	public static void main(String[] args){
		Node zero = new Node("0", new ArrayList<Node>());	
		Node one = new Node("1", new ArrayList<Node>());	
		Node two = new Node("2", new ArrayList<Node>());	
		Node three = new Node("3", new ArrayList<Node>());	
		Node four = new Node("4", new ArrayList<Node>());	
		Node five = new Node("5", new ArrayList<Node>());	
		Node six = new Node("6", new ArrayList<Node>());	

		zero.frontier.add(one);
		one.frontier.add(two);

		two.frontier.add(zero);
		two.frontier.add(three);

		three.frontier.add(two);

		four.frontier.add(six);

		five.frontier.add(four);

		six.frontier.add(five);
		
		Graph graph = new Graph(new ArrayList<Node>());
	
		graph.nodes.add(zero);
		graph.nodes.add(one);
		graph.nodes.add(two);
		graph.nodes.add(three);
		graph.nodes.add(four);
		graph.nodes.add(five);
		graph.nodes.add(six);

		
		Node eight = new Node("8", new ArrayList<Node>());

		GraphSearch g = new GraphSearch();
		
//		System.out.println(" Result: " + g.depthFirstSearch(one, eight, new boolean[graph.nodes.size()]));

	//	System.out.println(" Result: " + g.depthFirstSearch(one, three, new boolean[graph.nodes.size()]));

		//System.out.println(" Result: " + g.breadthFirstSearch(two, eight, new boolean[graph.nodes.size()]));
		
		System.out.println(" Result: " + g.breadthFirstSearch(two, one, new boolean[graph.nodes.size()]));
	}
}

