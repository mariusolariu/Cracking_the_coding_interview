import java.util.*;

public class Sol{
	private int hopLength[] = new int[]{1,2,3};


	public int getQuotient(int stepLength, int staircaseLength){

		return staircaseLength / stepLength;
	}

	public int countPossibilities(int totalSteps){
		int count = 0;

		//combinations contain 3
		//combinations contain 2

		for (int i = hopLength.length - 1; i > 1; i--){
			int currentHopLength = hopLength[i];

			int quotient = totalSteps / currentHopLength;

			if (quotient == 0){
				continue;
			}		

			ArrayList<Integer> l = new ArrayList<Integer>();

			while (quotient != 0){
				
				for (int j=1; j<= 2; j++){
					l.add(currentHopLength);
				}

				int difference = totalSteps - currentHopLength * quotient;

			}

		}

		//shuffle


		//remove duplicates
		

		//combinations contain 1 = 1
		count++;

		return count;
	}

	public static void main(String[] args){
		int[] arr = new int[]{3, 2, 1};

		Arrays.fill(arr, 0, 2, 0);
		for (int i: arr)
			System.out.println(i);


		Integer[] myArr = new Integer[]{Integer.valueOf(3), Integer.valueOf(2)};
		Arrays.sort(myArr);

		System.out.println();

		for (Integer i : myArr)
			System.out.println(i);
	}

}

