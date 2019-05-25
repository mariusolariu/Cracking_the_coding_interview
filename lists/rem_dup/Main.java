import java.util.*;

public class Main{
	/*
	public static LinkedList<Integer> removeDup(LinkedList<Integer> org){
		LinkedList<Integer> temp = new LinkedList<>();

		for (Integer o : org){
			if (!temp.contains(o)) temp.add(o);
		}

		return temp;
	}*/

	//without using a temporary buffer
	public static LinkedList<Integer> removeDup(LinkedList<Integer> org){
		int size = org.size();		
		int i = 0;

		while (i < size){
			Integer o = org.get(i);
			int first = org.indexOf(o);
			int other  = org.lastIndexOf(o);

			 
			if (first == other){
				i++;
				continue;
			 }else{
					//leave first occurence in the list
					if (first != i){
					    org.remove(other);
					    size--;
					}else{
						i++;
					}
			}
			
		}


		return org;
	}	
	
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<>();

		list.addAll(Arrays.asList(1, 3, 5, 3, 3, 5, 2, 4));
	//	list.addAll(Arrays.asList(3, 3, 3));
		
		list = removeDup(list);

		for (Integer e : list){
			System.out.print(e + " ");
		}
	}

}
