import java.util.*;

public class Sol{

	private int findMagicIndex(int[] arr, int startPos, int endPos){
		int middle = (startPos + endPos) / 2;

		if (endPos > startPos){
			return -1;
		}

		if (arr[middle] == middle){
			return middle;
		}

		if (middle < arr[middle]){ //go left
			return findMagicIndex(arr, startPos, middle - 1);
		}else{ //go right
			return findMagicIndex(arr, middle + 1, endPos);
		}


	}

	public int findMagicIndex(int[] arr){
		int magicIndex = findMagicIndex(arr, 0 , arr.length-1);

		System.out.println(" The magic index is: " + magicIndex);

		for (int i = 0; i < arr.length; i++){
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i : arr){
			System.out.print(i + " ");
		}

		return magicIndex;
	}

	public static void main(String[] args){
		int[] arr = {-2, -1, 1, 2, 4, 5};
	
		new Sol().findMagicIndex(arr);
	}

}

