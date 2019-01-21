import java.util.*;

public class BidirectionalSearch{

	//creates a bidirectional edge between the two nodes
	public static void addEdge(NodeNew a, NodeNew b){
		a.frontier.add(b);
		b.frontier.add(a);
	}

	private void expand(Queue<NodeNew> queue, boolean[] visited, int[] parents){

		NodeNew head = queue.poll();
		visited[head.id] = true;

		for (NodeNew f : head.frontier){
			
			if (!visited[f.id]){
				 parents[f.id] = head.id;
				 queue.add(f);
			}
		}

	}

	private ArrayList<Integer> reconstructPath(int[] parents, int intersection){
		ArrayList<Integer> result = new ArrayList<>();
		int i = parents[intersection];

		while (i != -1){
			result.add(i);
			i = parents[i];
		}

		return result;
	}	

	private void printPath(int[] s_parents, int[] d_parents, int intersection){
		ArrayList<Integer> firstPart = reconstructPath(s_parents, intersection);
		ArrayList<Integer> secondPart = reconstructPath(d_parents, intersection);

		Collections.reverse(firstPart);

		System.out.println("Path: ");

		for (Integer i : firstPart){
			System.out.print(i);
		}

		System.out.print(intersection);

		for (Integer i : secondPart){
			System.out.print(i);
		}
	}

	private ArrayList<NodeNew> intersection(Queue<NodeNew> a, Queue<NodeNew> b){
		ArrayList<NodeNew> result = new ArrayList<>();

		for (NodeNew i : a){
			if (b.contains(i)) result.add(i);
		}

		return result;
	}

	public  boolean bidiSearch(GraphN graph, NodeNew source, NodeNew destination){
		boolean result = false;
		int graph_size = graph.nodes.size();

		boolean[] s_visited = new boolean[graph_size];
		boolean[] d_visited = new boolean[graph_size];

		//each node has a parent theoretically
		//s_parent[i] == the index of the parent of the node i (recursively we can get from a node to the original source from which bfs expanded) 
		int[] s_parents = new int[graph_size];
		int[] d_parents = new int[graph_size];

		for (int i = 0; i < graph_size; i++){
			s_visited[i] = false;
			d_visited[i] = false;

			s_parents[i] = -1;
			d_parents[i] = -1;
		}

		Queue<NodeNew> s_queue = new LinkedList<>();
		Queue<NodeNew> d_queue = new LinkedList<>();

	
		s_queue.add(source);
		d_queue.add(destination);

			while (!s_queue.isEmpty() &&
				   !d_queue.isEmpty()){
				
				expand(s_queue, s_visited, s_parents);
				expand(d_queue, d_visited, d_parents);

				ArrayList<NodeNew> intersectionNodes = intersection(s_queue, d_queue);

				// how does contains work on a collection of nonstandard objects
				for (NodeNew i : intersectionNodes){
					printPath(s_parents, d_parents, i.id);
				}
				
				//stop everything once the path(s) was found
				if (intersectionNodes.size() >= 0){
					return true;
				}

			}

		return result;
	}

	public static void main(String[] args){
		NodeNew zero = new NodeNew(0, new ArrayList<NodeNew>());
		NodeNew one = new NodeNew(1, new ArrayList<NodeNew>());
		NodeNew two = new NodeNew(2, new ArrayList<NodeNew>());
		NodeNew three = new NodeNew(3, new ArrayList<NodeNew>());
		NodeNew four = new NodeNew(4, new ArrayList<NodeNew>());
		NodeNew five = new NodeNew(5, new ArrayList<NodeNew>());
		NodeNew six = new NodeNew(6, new ArrayList<NodeNew>());
		NodeNew seven = new NodeNew(7, new ArrayList<NodeNew>());
		NodeNew eight = new NodeNew(8, new ArrayList<NodeNew>());
		NodeNew nine = new NodeNew(9, new ArrayList<NodeNew>());
		NodeNew ten = new NodeNew(10, new ArrayList<NodeNew>());
		NodeNew eleven = new NodeNew(11, new ArrayList<NodeNew>());
		NodeNew twelve = new NodeNew(12, new ArrayList<NodeNew>());
		NodeNew thirteen = new NodeNew(13, new ArrayList<NodeNew>());
		NodeNew fourteen = new NodeNew(14, new ArrayList<NodeNew>());

		addEdge(zero, four);
		addEdge(one, four);
		addEdge(four, six);

		addEdge(two, five);
		addEdge(three, five);
		addEdge(five, six);

		addEdge(six, seven);

		addEdge(seven, eight);

		addEdge(eight, nine);
		addEdge(nine, eleven);
		addEdge(nine, twelve);

		addEdge(eight, ten);
		addEdge(ten, thirteen);
		addEdge(ten, fourteen);

		GraphN graph = new GraphN(new ArrayList<NodeNew>());	

		graph.nodes.add(zero);
		graph.nodes.add(one);
		graph.nodes.add(two);
		graph.nodes.add(three);
		graph.nodes.add(four);
		graph.nodes.add(five);
		graph.nodes.add(six);
		graph.nodes.add(seven);
		graph.nodes.add(eight);
		graph.nodes.add(nine);
		graph.nodes.add(ten);
		graph.nodes.add(eleven);
		graph.nodes.add(twelve);
		graph.nodes.add(thirteen);
		graph.nodes.add(fourteen);
		
		BidirectionalSearch t = new BidirectionalSearch();
		t.bidiSearch(graph, zero, fourteen);
	}

}


