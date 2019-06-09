import java.util.*;

/* The solution to the problem for when duplicate values are allowed in the ascending list of numbers
*/
public class BookSol{

	private int magicFast(int[] array, int start, int end){
		if (end < start) return -1;

		int midIndex = (start + end) / 2;
		int midValue = array[midIndex];

		if (midValue == midIndex) return midIndex;
		
		//Search left
		int leftIndex = Math.min(midIndex - 1, midValue);
		int left = magicFast(array, start, leftIndex);
		if (left >= 0) return left;

		//Search
		int rightIndex = Math.max(midIndex + 1, midValue);
		int right = magicFast(array, rightIndex, end);

		return right;
	}

	public int magicFast(int[] array){
		return magicFast(array, 0 , array.length - 1);
	}

	public static void main(String[] args){
		int[] array = new int[]{-10, -5, 2, 2,  2, 3, 4, 7, 9, 12, 13};

		int magicIndex = new BookSol().magicFast(array);

		System.out.println(" Magic index: " + magicIndex);
	}

}

