import java.util.*;

//These traversal methods are defined for binary (maximum two children) tree traversals
public class TreeTraversalMeth{

	//In-Order -> Left - Parent - Right (LPR)
	public static void inOrder(BinaryNode n){
	
		if (n != null){
			inOrder(n.left);
	
			//operation to be performed on note
			System.out.print(n.name + " ");

			inOrder(n.right);

		}	
	}

	
 	// PLR
 	public static void preOrder(BinaryNode n){
		
		if (n != null){
			//doSmthWithThisNodeData();
			System.out.print(n.name + " ");

			preOrder(n.left);
			preOrder(n.right);
		}
	}

	// LRP
	public static void postOrder(BinaryNode n){
		if (n != null){
			postOrder(n.left);
			postOrder(n.right);
	
			//doSmthWithThisNodeData();
			System.out.print(n.name + " ");

		}

	}
}

