import java.util.*;

public class Sol{

	/*
    *@ return -  null if the node is the rightmost node of the tree (i.e. has no successor)
 	* 	
  	*/
	private BinaryNodeEnhanced findSuccessor(BinaryNodeEnhanced searchedNode, BinaryNodeEnhanced aParent){
		if (searchedNode.right != null) return searchedNode.right;
		
		if (aParent == null) return null; //we reached the root node, there is no succesor for rightmost node

		if (aParent.id >= searchedNode.id) return aParent;
		else return findSuccessor(searchedNode, aParent.parent);

	}
	
	public BinaryNodeEnhanced findSuccessor(BinaryNodeEnhanced searchedNode){
		return findSuccessor(searchedNode, searchedNode.parent);
	}

	public static void main(String[] args){
		BinaryNodeEnhanced root = new BinaryNodeEnhanced(4);
		BinaryNodeEnhanced one = new BinaryNodeEnhanced(1);
		BinaryNodeEnhanced two = new BinaryNodeEnhanced(2);
		BinaryNodeEnhanced three = new BinaryNodeEnhanced(3);
		BinaryNodeEnhanced four = new BinaryNodeEnhanced(4);
		BinaryNodeEnhanced five = new BinaryNodeEnhanced(5);
		BinaryNodeEnhanced six = new BinaryNodeEnhanced(6);
		BinaryNodeEnhanced seven = new BinaryNodeEnhanced(7);
		BinaryNodeEnhanced eight = new BinaryNodeEnhanced(8);

		root.left = two;
		root.right = seven;

		two.parent = root;
		two.left = one;
		two.right = three;

		seven.parent = root;
		seven.left = six;
		seven.right = eight;

		one.parent = two;
		three.parent = two;

		six.parent = seven;
		eight.parent = seven;

		Sol s = new Sol();

		BinaryNodeEnhanced successor = s.findSuccessor(three);

		System.out.println("Successor of " + three.id + " is " + ( (successor != null) ? successor.id : "non-existent") );
	
		successor = s.findSuccessor(eight);
		System.out.println("Successor of " + eight.id + " is " + ( (successor != null) ? successor.id : "non-existent") );

		successor = s.findSuccessor(six);
		System.out.println("Successor of " + six.id + " is " + ( (successor != null) ? successor.id : "non-existent") );

	}

}

