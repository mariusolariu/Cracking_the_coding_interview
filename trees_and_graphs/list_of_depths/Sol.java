import java.util.*;

public class Sol{
	private ArrayList<ArrayList<Integer>> listOfLists;

	private void inOrderTrav(BinaryNode node, int level){

		if (node != null){
			int size = listOfLists.size();
			
			if (size <= level){
				ArrayList<Integer> newList = new ArrayList<Integer>();
				listOfLists.add(newList);
			}

			listOfLists.get(level).add(Integer.valueOf(node.id));
		
			inOrderTrav(node.left, level + 1);
			inOrderTrav(node.right, level + 1);
		}

	}

	public ArrayList<ArrayList<Integer>> createListOfDepths(BinaryNode root){
		listOfLists = new ArrayList<ArrayList<Integer>>();
	
		inOrderTrav(root, 0);

		return listOfLists;
	}

	public static void main(String[] args){
		// int[] arr = new int[]{1,2,3,4,5,6,7};
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

		BinaryNode bst = MinimalTree.createMinimalBST(arr);
		
		Sol s = new Sol();

		ArrayList<ArrayList<Integer>> listOfLists = s.createListOfDepths(bst);

		System.out.println(listOfLists.size());

		for (int i = 0; i < listOfLists.size(); i++){
				ArrayList<Integer> l  = listOfLists.get(i);
				
				System.out.print("List " + i + ":");
				for (Integer j : l){
					System.out.print(" " + j);
				}

				System.out.println();

		}
	}

}

