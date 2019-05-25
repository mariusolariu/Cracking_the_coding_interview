import java.util.*;

public class Sol{

	public static Integer findKthElement(LinkedList<Integer> myList,int k){
		int size = myList.size();

		if (k > size - 1){
			System.out.println(" There list is too small for k = " + k);
			return null;
		}


		int kthIndex = size - k - 1;

		Iterator<Integer> listIterator = myList.iterator();

	//O(n) is the best time complexity that you can get	
		int i = 0;
		Integer element = null;
		while(listIterator.hasNext()){
			
			if (i == kthIndex){
				element = listIterator.next();
				break;
			}

			

			i++;
		}

		return element;
	}

	public static void main(String[] args){
		LinkedList<Integer> myList = new LinkedList<>(Arrays.asList(1,2,3));

		System.out.println(findKthElement(myList, 2);
	
			
	}

}

