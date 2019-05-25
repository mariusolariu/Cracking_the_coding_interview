package root;
import java.util.*;

public class Sol2{

	public void addTheCarry(LinkedList<Integer> result, int carry, int index){
			int d;

			if (index == -1){
				result.addFirst(new Integer(carry));
				return;
			}

			d = result.get(index) + carry;

			result.set(index, d % 10);

			if ( d >= 10){
			    carry = d / 10;
			  	this.addTheCarry(result, carry, index - 1);
			}
			
			
	}

	//add leading 0s
	public void makeListsSameSize(int offset, LinkedList<Integer> smallerList){
		int i = 0;

		while (i  < offset){
			smallerList.addFirst(0);
			i++;
		}
	}

	//the digits are stored in forward order
	public LinkedList<Integer> sumLists(LinkedList<Integer> a, LinkedList<Integer> b){
			LinkedList<Integer> shorterList;
			int maxSize;
			int minSize;
			int a_size = a.size();
			int b_size = b.size();

			if (a_size > b_size){
				shorterList = b;
				maxSize = a_size;
				minSize = b_size;
			}else{
				shorterList = a;
				maxSize = b_size;
				minSize = a_size;
			}
			
			if (a_size != b_size)	makeListsSameSize(maxSize - minSize, shorterList);		

 			int i = 0;
			int carry = 0;
			LinkedList<Integer> result = new LinkedList<>();
						

			while (i < maxSize){
					
				int d1 = a.get(i);
				int d2 = b.get(i);

				int d3 = d1 + d2;

				carry = d3 / 10;
				d3 = d3 % 10;

				result.add(d3); 

				if (carry != 0) this.addTheCarry(result, carry, i - 1);		

				i++;
			}			

		return result;
	}

	public static void main(String[] args){
		Sol2 s = new Sol2();
		LinkedList<Integer> a = new LinkedList<>(Arrays.asList(9,9,9));
		LinkedList<Integer> b = new LinkedList<>(Arrays.asList(1));
      
		LinkedList<Integer> result = s.sumLists(a,b);

		System.out.println("The sum: ");

		for (Integer i : result){
			System.out.print(i);
		}

	}

}
