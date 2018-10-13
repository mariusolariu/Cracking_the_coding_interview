import java.util.*;

public class Sol{

	public static LinkedList<Integer> sumLists(LinkedList<Integer> a, LinkedList<Integer> b){
			LinkedList<Integer> longerList;
			LinkedList<Integer> shorterList;
			int maxSize;
			int minSize;

			if (a.size() > b.size()){
				longerList = a;
				shorterList = b;
				maxSize = a.size();
				minSize = b.size();
			}else{
				longerList = b;
				shorterList = a;
				maxSize = b.size();
				minSize = a.size();
			}
					
 			int i = 0;
			int carry = 0;
			LinkedList<Integer> result = new LinkedList<>();
						

			while (i < maxSize){
				int d1 = 0;
					
					if (i < minSize) d1 = shorterList.get(i);

				int d2 = longerList.get(i);
				int d3 = d1 + d2 + carry;

				carry = d3 / 10;
				d3 = d3 % 10;

				result.add(d3); 
		
				i++;
			}			

			if (carry != 0) result.add(carry);

		return result;
	}

	public static void main(String[] args){
		LinkedList<Integer> a = new LinkedList<>(Arrays.asList());
		LinkedList<Integer> b = new LinkedList<>(Arrays.asList(5, 9, 2));

		LinkedList<Integer> result = sumLists(a, b);

		StringBuilder buff = new StringBuilder("");
		for (Integer i : result){
			buff.insert(0, i);
		}

		System.out.println("The result:" + buff.toString());
	}

}

