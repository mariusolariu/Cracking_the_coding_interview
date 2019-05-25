import java.util.*;

public class Sol{
	private static Object NON_VALID = null;
	//Assuming that equal values are always put in left subtree
	
	//public boolean validateBST(BinaryNode n){
	//	if (n != null){
			
	//		if (n.left != null){
	//			if (n.left.id > n.id) return false;
	//		}


	//		if (n.right != null){
	//			if (n.right.id <= n.id) return false;
	//		}

	//		//for the current node and its children the rule holds
	//		boolean leftSubtree = true, rightSubtree = true;
	//		if (n.left != null) leftSubtree = validateBST(n.left);
	//		if (n.right != null) rightSubtree = validateBST(n.right);

	//		return leftSubtree && rightSubtree;
	//	}else{
	//		return true;
	//	}
	//}


	private List<Integer> isBST(BinaryNode n){
		if (n != null){
			List<Integer> leftSubTreeNodes = new ArrayList<Integer>();
			List<Integer> rightSubTreeNodes = new ArrayList<Integer>();

			if (n.left != null) leftSubTreeNodes = isBST(n.left);
			if (n.right != null) rightSubTreeNodes = isBST(n.right);

			ArrayList<Integer> resultSubTree = new ArrayList<Integer>();

			for (Integer i : leftSubTreeNodes){
				if (i > n.id){
					resultSubTree = null;
					break;
				}
			}


			if (resultSubTree != null){ //if for the left subtree the rule didn't hold there is no point to check for right subtree
				
				for (Integer i : rightSubTreeNodes){
					if (i <= n.id){
						resultSubTree = null;
						break;
					}

				}
			}
	

		   if (resultSubTree == null) return null;
		   else{
				resultSubTree.addAll(leftSubTreeNodes);
				resultSubTree.add(n.id);
				resultSubTree.addAll(rightSubTreeNodes);
			
				return resultSubTree;
		   }
		}else{
			return new ArrayList<Integer>();
		}
	}

	public boolean validateBST(BinaryNode n){
		return isBST(n) != null;
	}



	public static void main(String[] args){
		Sol s = new Sol();
		BinaryNode bst = new BinaryNode(5);	

		BinaryNode one = new BinaryNode(1);	
		BinaryNode two = new BinaryNode(2);	
		BinaryNode three = new BinaryNode(3);	
		BinaryNode four = new BinaryNode(4);	
		BinaryNode five	 = new BinaryNode(5);	
		BinaryNode eighteen	 = new BinaryNode(18);	

		bst.left = two;
		bst.right = eighteen;

		two.left = one;
		two.right = three;

		System.out.println("Is tree BST? " + (s.validateBST(bst) ? "Yes" : "No"));	

		//making the tree non-bst
		// BinaryNode ten = new BinaryNode(10);
		// three.right = ten;
		// System.out.println("Is tree BST? " + (s.validateBST(bst) ? "Yes" : "No"));	
		

		eighteen.id = 2;
		System.out.println("Is tree BST? " + (s.validateBST(bst) ? "Yes" : "No"));	
	}

}

