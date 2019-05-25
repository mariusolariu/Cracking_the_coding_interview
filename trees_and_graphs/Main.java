import java.util.*;

public class Main{

	public static void main(String[] args){
		BinaryNode one = new BinaryNode("1");
		BinaryNode two = new BinaryNode("2");
		BinaryNode three = new BinaryNode("3");
		BinaryNode four = new BinaryNode("4");
		BinaryNode five = new BinaryNode("5");
		BinaryNode six = new BinaryNode("6");
		BinaryNode seven = new BinaryNode("7");

		four.left = two;
		four.right = six;

		two.left = one;
		two.right = three;

		six.left = five;
		six.right = seven;	

		System.out.print("In Order: ");
		TreeTraversalMeth.inOrder(four);
		System.out.println();

		System.out.print("Pre Order: ");
		TreeTraversalMeth.preOrder(four);
		System.out.println();

		System.out.print("Post Order: ");
		TreeTraversalMeth.postOrder(four);
		System.out.println();

	}

}

