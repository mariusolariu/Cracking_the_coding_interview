import java.util.*;

public class Sol{
	private static final int UNBALANCED = -1;

	//post-traversal (LRP)
	private int checkBalanced(BinaryNode n, int depth){
		
		if (n != null){
			int depthLeft = checkBalanced(n.left, depth + 1);
			int depthRight = checkBalanced(n.right, depth + 1);
	
			int difference = Math.abs(depthLeft - depthRight);

            if (difference > 1) return UNBALANCED;
			else return Math.max(depthLeft, depthRight);
			
		}else{
			return depth - 1;
		}

	}


	public boolean isBalanced(BinaryNode n){
		int result = checkBalanced(n, 0);

		return result != UNBALANCED;
	}
	
	public static void main(String[] args){
		Sol test = new Sol();
	
		BinaryNode balancedTree = new BinaryNode(1);	

		BinaryNode two = new BinaryNode(2);	
		BinaryNode three = new BinaryNode(3);	
		BinaryNode four = new BinaryNode(4);	
		BinaryNode five	 = new BinaryNode(5);	

		// balancedTree.left = two;	
		// balancedTree.right = three;

		// two.left = four;
		// two.right = five;

		// System.out.println("Is three balanced? " + (test.isBalanced(balancedTree) ? "Yes" : "No") );

		BinaryNode unbalancedTree = new BinaryNode(1);	
		unbalancedTree.left = two;
		two.left = three;

		System.out.println("Is three balanced? " + (test.isBalanced(unbalancedTree) ? "Yes" : "No") );
	
		
	}

}

