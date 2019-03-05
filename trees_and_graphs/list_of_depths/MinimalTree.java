
import java.util.*;

public class MinimalTree{
  private int[] sortedArr;
	//TODO
	public BinaryNode binarySearch(BinaryNode n, int value){

		return null;
	}

	//TODO
	public boolean binarySearch2(int[] sortedArr, int value){

		return false;
	}

	//LPR
	public static void inOrderPrint(BinaryNode n){
		if (n != null){
			inOrderPrint(n.left);
			System.out.println(n.id + " ");
			inOrderPrint(n.right);	
		}

	}

	public static void rec(int sortedArr[], int startIndex, int endIndex, BinaryNode parent, int lastLvl, int currentLvl){
	  currentLvl++;
	  int middle = (startIndex + endIndex) / 2;
	  int leftIndex = (startIndex + middle) / 2;
		int rightIndex = (middle + endIndex) / 2;


    //when size is odd, there won't be a left child for the rightmost lowest parent
		  if (endIndex - startIndex != 2) {
        parent.left = new BinaryNode(sortedArr[leftIndex]);
      }

		parent.right = new BinaryNode(sortedArr[rightIndex]);

		//terminal nodes
		if (currentLvl == lastLvl) return;

		rec(sortedArr, startIndex, middle, parent.left, lastLvl, currentLvl);
		rec(sortedArr, middle + 1, endIndex, parent.right, lastLvl, currentLvl);

	}

	private static double log2(double a){
		return Math.log(a) / Math.log(2);
	}

	private static BinaryNode createMinimalBST(int arr[], int start, int end){
	  if (start > end){
	    return null;
    }

    int mid = (start + end) / 2;

    BinaryNode n = new BinaryNode(arr[mid]);
    n.left = createMinimalBST(arr, start, mid - 1);
    n.right = createMinimalBST(arr, mid + 1, end);

    return n;
  }

	public static BinaryNode createMinimalBST(int[] sortedArr){
//		BinaryNode rootNode = new BinaryNode(sortedArr[sortedArr.length / 2]);
//
//		rec( sortedArr,0, sortedArr.length, rootNode, (int) log2((double)sortedArr.length), 0);

		return createMinimalBST(sortedArr, 0, sortedArr.length - 1);
	}

	public static void main(String[] args){
		int[] sortedArr = new int[]{1,2,3,4,5,6};
//		int[] sortedArr = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
		//int[] sortedArr = new int[]{1,2,3,4,5,6,7,8,9,10};
		BinaryNode root = createMinimalBST(sortedArr);
		inOrderPrint(root);	

	}

}

